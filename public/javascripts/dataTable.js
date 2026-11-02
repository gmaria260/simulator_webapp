document.addEventListener("DOMContentLoaded", () => {
    const tableBody = document.getElementById("dataTableBody");
    const rowCount = document.getElementById("rowCount");

    if (!tableBody || !rowCount) return;

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
            <td><input type="number" class="data-cell" step="any"></td>
            <td><input type="number" class="data-cell" step="any"></td>
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

    updateTable();
});