document.addEventListener("DOMContentLoaded", () => {
    const tableBody = document.getElementById("dataTableBody");
    const rowCount = document.getElementById("rowCount");
    const calculateButton = document.querySelector(".calculate-button");
    const predictionButton = document.getElementById("predictButton");
    const predictionInput = document.getElementById("predictionX");
    const predictedY = document.getElementById("predictedY");
    const calculationMessage = document.getElementById("calculationMessage");
    const predictionMessage = document.getElementById("predictionMessage");
    const graph = document.querySelector(".default-graph");
    const plot = document.getElementById("regressionPlot");
    const graphTicks = document.getElementById("graphTicks");

    if (
        !tableBody || !rowCount || !calculateButton || !predictionButton ||
        !predictionInput || !predictedY || !calculationMessage ||
        !predictionMessage || !graph || !plot || !graphTicks
    ) return;

    let fittedModel = null;
    const svgNamespace = "http://www.w3.org/2000/svg";

    function updateTable() {
        const rows = tableBody.querySelectorAll("tr");

        rows.forEach((row, index) => {
            const rowNumber = row.querySelector(".row-number");
            if (rowNumber) {
                rowNumber.textContent = index + 1;
            }
        });

        rowCount.textContent =
            `${rows.length} ${rows.length === 1 ? "row" : "rows"}`;
    }

    function addRow() {
        const newRow = document.createElement("tr");

        newRow.innerHTML = `
            <td class="row-number"></td>
            <td><input type="number" class="data-cell" step="any" aria-label="X value"></td>
            <td><input type="number" class="data-cell" step="any" aria-label="Y value"></td>
        `;

        tableBody.appendChild(newRow);
        updateTable();

        const firstInput = newRow.querySelector(".data-cell");
        if (firstInput) firstInput.focus();
    }

    tableBody.addEventListener("keydown", (event) => {
        if (event.key !== "Enter") return;

        const input = event.target;
        if (!input.classList.contains("data-cell")) return;

        event.preventDefault();

        const currentRow = input.closest("tr");
        const lastRow = tableBody.lastElementChild;

        if (currentRow === lastRow) {
            const cells = currentRow.querySelectorAll(".data-cell");
            const lastCell = cells[cells.length - 1];

            if (input === lastCell) {
                addRow();
            }
        }
    });

    function formatNumber(value) {
        return Number(value.toPrecision(6)).toString();
    }

    function readObservations() {
        const observations = [];

        for (const [index, row] of Array.from(tableBody.querySelectorAll("tr")).entries()) {
            const cells = row.querySelectorAll(".data-cell");
            const xText = cells[0].value.trim();
            const yText = cells[1].value.trim();

            if (xText === "" && yText === "") continue;
            if (xText === "" || yText === "") {
                throw new Error(`Row ${index + 1} needs both an X and a Y value.`);
            }

            const x = Number(xText);
            const y = Number(yText);
            if (!Number.isFinite(x) || !Number.isFinite(y)) {
                throw new Error(`Row ${index + 1} must contain finite numbers.`);
            }
            observations.push({ x, y });
        }

        if (observations.length < 2) {
            throw new Error("Enter at least two complete X / Y pairs.");
        }

        return observations;
    }

    function fitRegression(observations) {
        const xScale = observations.reduce((scale, observation) =>
            Math.max(scale, Math.abs(observation.x)), 0);
        const yScale = observations.reduce((scale, observation) =>
            Math.max(scale, Math.abs(observation.y)), 0) || 1;
        if (xScale === 0) throw new Error("X values must not all be the same.");

        const normalizedX = observations.map(observation => observation.x / xScale);
        const normalizedY = observations.map(observation => observation.y / yScale);
        const meanX = normalizedX.reduce((sum, x) => sum + x, 0) / observations.length;
        const meanY = normalizedY.reduce((sum, y) => sum + y, 0) / observations.length;
        const varianceX = normalizedX.reduce((sum, x) =>
            sum + Math.pow(x - meanX, 2), 0);
        if (varianceX === 0) throw new Error("X values must include at least two different numbers.");

        const covariance = observations.reduce((sum, observation, index) =>
            sum + (normalizedX[index] - meanX) * (normalizedY[index] - meanY), 0);
        const normalizedSlope = covariance / varianceX;
        const slope = (yScale / xScale) * normalizedSlope;
        const intercept = yScale * (meanY - normalizedSlope * meanX);
        if (!Number.isFinite(slope) || !Number.isFinite(intercept)) {
            throw new Error("These values are too large to calculate a finite regression equation.");
        }

        const totalVariation = normalizedY.reduce((sum, y) =>
            sum + Math.pow(y - meanY, 2), 0);
        const residualVariation = observations.reduce((sum, observation, index) => {
            const predicted = meanY + normalizedSlope * (normalizedX[index] - meanX);
            return sum + Math.pow(normalizedY[index] - predicted, 2);
        }, 0);
        const rSquared = totalVariation === 0
            ? 1
            : Math.max(0, Math.min(1, 1 - residualVariation / totalVariation));

        return { xScale, yScale, meanX, meanY, normalizedSlope, slope, intercept, rSquared };
    }

    function createSvgElement(tagName, attributes) {
        const element = document.createElementNS(svgNamespace, tagName);
        for (const [name, value] of Object.entries(attributes)) {
            element.setAttribute(name, value);
        }
        return element;
    }

    function clearElement(element) {
        while (element.firstChild) {
            element.removeChild(element.firstChild);
        }
    }

    function renderGraph(observations, model, xName, yName) {
        clearElement(plot);
        clearElement(graphTicks);
        const normalizedX = observations.map(observation => observation.x / model.xScale);
        const normalizedY = observations.map(observation => observation.y / model.yScale);
        const minX = normalizedX.reduce((minimum, value) => Math.min(minimum, value), Infinity);
        const maxX = normalizedX.reduce((maximum, value) => Math.max(maximum, value), -Infinity);
        const minY = normalizedY.reduce((minimum, value) => Math.min(minimum, value), Infinity);
        const maxY = normalizedY.reduce((maximum, value) => Math.max(maximum, value), -Infinity);
        const xRange = maxX - minX;
        const yRange = maxY - minY || 1;
        const xPadding = xRange * 0.05;
        const yPadding = yRange * 0.05;
        const plotMinX = minX - xPadding;
        const plotMaxX = maxX + xPadding;
        const plotMinY = minY - yPadding;
        const plotMaxY = maxY + yPadding;
        const xPosition = value => 80 + ((value - plotMinX) / (plotMaxX - plotMinX)) * 680;
        const yPosition = value => 370 - ((value - plotMinY) / (plotMaxY - plotMinY)) * 300;

        const lineStartY = model.meanY + model.normalizedSlope * (minX - model.meanX);
        const lineEndY = model.meanY + model.normalizedSlope * (maxX - model.meanX);
        plot.appendChild(createSvgElement("line", {
            class: "regression-line",
            x1: xPosition(minX),
            y1: yPosition(lineStartY),
            x2: xPosition(maxX),
            y2: yPosition(lineEndY)
        }));

        observations.forEach((observation, index) => {
            const point = createSvgElement("circle", {
                class: "data-point",
                cx: xPosition(normalizedX[index]),
                cy: yPosition(normalizedY[index]),
                r: 5
            });
            const title = createSvgElement("title", {});
            title.textContent = `${xName}: ${formatNumber(observation.x)}, ${yName}: ${formatNumber(observation.y)}`;
            point.appendChild(title);
            plot.appendChild(point);
        });

        const ticks = [
            { x: 80, y: 390, text: formatNumber(minX * model.xScale), anchor: "start" },
            { x: 760, y: 390, text: formatNumber(maxX * model.xScale), anchor: "end" },
            { x: 72, y: 374, text: formatNumber(minY * model.yScale), anchor: "end" },
            { x: 72, y: 78, text: formatNumber(maxY * model.yScale), anchor: "end" }
        ];
        ticks.forEach(tick => {
            graphTicks.appendChild(createSvgElement("text", {
                x: tick.x,
                y: tick.y,
                "text-anchor": tick.anchor
            })).textContent = tick.text;
        });

        document.getElementById("xAxisLabel").textContent = xName;
        document.getElementById("yAxisLabel").textContent = yName;
        graph.setAttribute("aria-label", `Scatter plot with regression line for ${xName} and ${yName}`);
    }

    function clearResults() {
        fittedModel = null;
        document.getElementById("equationResult").textContent = "—";
        document.getElementById("slopeResult").textContent = "—";
        document.getElementById("interceptResult").textContent = "—";
        document.getElementById("rSquaredResult").textContent = "—";
        predictedY.textContent = "—";
        predictionMessage.textContent = "";
        clearElement(plot);
        clearElement(graphTicks);
        document.getElementById("xAxisLabel").textContent = "X";
        document.getElementById("yAxisLabel").textContent = "Y";
        graph.setAttribute("aria-label", "Empty graph with X and Y axes");
    }

    calculateButton.addEventListener("click", () => {
        clearResults();
        calculationMessage.textContent = "";

        try {
            const observations = readObservations();
            const model = fitRegression(observations);
            const names = Array.from(document.querySelectorAll(".column-name"))
                .map((input, index) => input.value.trim() || (index === 0 ? "X" : "Y"));
            const [xName, yName] = names;
            fittedModel = model;

            document.getElementById("equationResult").textContent =
                `${yName} = ${formatNumber(model.intercept)} ${model.slope < 0 ? "-" : "+"} ${formatNumber(Math.abs(model.slope))}${xName}`;
            document.getElementById("slopeResult").textContent = formatNumber(model.slope);
            document.getElementById("interceptResult").textContent = formatNumber(model.intercept);
            document.getElementById("rSquaredResult").textContent = formatNumber(model.rSquared);
            renderGraph(observations, model, xName, yName);
        } catch (error) {
            calculationMessage.textContent = error.message;
        }
    });

    predictionButton.addEventListener("click", () => {
        predictionMessage.textContent = "";
        predictedY.textContent = "—";

        if (!fittedModel) {
            predictionMessage.textContent = "Calculate a regression before predicting.";
            return;
        }

        const x = Number(predictionInput.value);
        if (predictionInput.value.trim() === "" || !Number.isFinite(x)) {
            predictionMessage.textContent = "Enter a finite X value to predict Y.";
            return;
        }

        const normalizedPrediction = fittedModel.meanY +
            fittedModel.normalizedSlope * (x / fittedModel.xScale - fittedModel.meanX);
        const prediction = fittedModel.yScale * normalizedPrediction;
        if (!Number.isFinite(prediction)) {
            predictionMessage.textContent = "This X value produces a prediction outside the supported numeric range.";
            return;
        }

        predictedY.textContent = formatNumber(prediction);
    });

    updateTable();
});