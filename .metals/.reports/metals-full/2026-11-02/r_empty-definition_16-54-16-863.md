error id: file:///C:/xampp/htdocs/simulator_webapp/app/views/index.scala.html:scala/Predef.`???`().
file:///C:/xampp/htdocs/simulator_webapp/app/views/index.scala.html
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 418
uri: file:///C:/xampp/htdocs/simulator_webapp/app/views/index.scala.html
text:
```scala
@()(implicit assetsFinder: AssetsFinder)

@main("Linear Regression Simulator") {

    <div class="simulator">

        <!-- Header -->
        <header class="simulator-header">
            <div class="header-content">

                <div class="simulator-logo" aria-label="Linear regression logo">
                    <div class="simulator-logo">
    <img
        src="@assetsFinder.path("images/logo.pn@@g")"
        alt="Linear Regression Simulator logo"
    >
</div>
                </div>

                <h1>Linear Regression Simulator</h1>

            </div>
        </header>

        <!-- Main content -->
        <main class="simulator-main">

            <section class="simulator-intro">
                <h2>Explore Linear Regression</h2>

                <p>
                    Enter paired X and Y values to explore their relationship.
                    The graph and regression results will help you understand
                    the trend in your data.
                </p>
            </section>

            <div class="simulator-workspace">

                <!-- Data input -->
                <section class="data-panel">

                    <div class="data-panel-heading">
                        <div>
                            <h2>Data Input</h2>

                            <p class="section-description">
                                Enter or paste your data into the table.
                            </p>
                        </div>

                        <span class="data-badge">X / Y DATA</span>
                    </div>

                    <div class="table-toolbar">
                        <span>Dataset</span>
                        <span id="rowCount">0 rows</span>
                    </div>

                    <div class="editable-table-wrapper">
                        <table class="editable-data-table">

                            <thead>
                                <tr>
                                    <th class="row-number-heading">#</th>

                                    <th>
                                        <input
                                            class="column-name"
                                            type="text"
                                            value="X"
                                            aria-label="First column name"
                                        >
                                    </th>

                                    <th>
                                        <input
                                            class="column-name"
                                            type="text"
                                            value="Y"
                                            aria-label="Second column name"
                                        >
                                    </th>
                                </tr>
                            </thead>

                            <tbody id="dataTableBody">
                                <tr>
                                    <td class="row-number">1</td>

                                    <td>
                                        <input
                                            class="data-cell"
                                            type="number"
                                            step="any"
                                            aria-label="Row 1 X value"
                                        >
                                    </td>

                                    <td>
                                        <input
                                            class="data-cell"
                                            type="number"
                                            step="any"
                                            aria-label="Row 1 Y value"
                                        >
                                    </td>
                                </tr>
                            </tbody>

                        </table>
                    </div>

                    <p class="table-hint">
                        Press Enter in the last cell to add another row.
                    </p>

                    <button type="button" class="calculate-button">
                        Calculate Regression
                    </button>

                </section>

                <!-- Graph and results -->
                <div class="visualization-column">

                    <section class="graph-panel">

                        <div class="panel-heading">
                            <div>
                                <h2>Data Visualization</h2>

                                <p class="section-description">
                                    Scatter plot and regression line
                                </p>
                            </div>
                        </div>

                        <div class="graph-container">

                            <svg
                                class="default-graph"
                                viewBox="0 0 800 450"
                                role="img"
                                aria-label="Empty graph with X and Y axes"
                            >

                                <!-- Grid lines -->
                                <g class="graph-grid">
                                    <line x1="80" y1="70" x2="760" y2="70" />
                                    <line x1="80" y1="130" x2="760" y2="130" />
                                    <line x1="80" y1="190" x2="760" y2="190" />
                                    <line x1="80" y1="250" x2="760" y2="250" />
                                    <line x1="80" y1="310" x2="760" y2="310" />
                                    <line x1="80" y1="370" x2="760" y2="370" />

                                    <line x1="80" y1="70" x2="80" y2="370" />
                                    <line x1="216" y1="70" x2="216" y2="370" />
                                    <line x1="352" y1="70" x2="352" y2="370" />
                                    <line x1="488" y1="70" x2="488" y2="370" />
                                    <line x1="624" y1="70" x2="624" y2="370" />
                                    <line x1="760" y1="70" x2="760" y2="370" />
                                </g>

                                <!-- Axes -->
                                <g class="graph-axes">
                                    <line x1="80" y1="370" x2="760" y2="370" />
                                    <line x1="80" y1="370" x2="80" y2="50" />
                                </g>

                                <!-- Axis labels -->
                                <g class="graph-labels">
                                    <text x="420" y="425" text-anchor="middle">
                                        X
                                    </text>

                                    <text
                                        x="25"
                                        y="220"
                                        text-anchor="middle"
                                        transform="rotate(-90 25 220)"
                                    >
                                        Y
                                    </text>
                                </g>

                            </svg>

                        </div>
                    </section>

                    <!-- Regression results -->
                    <section class="regression-panel">

                        <h2>Regression Results</h2>

                        <div class="results-grid">

                            <div class="result-card equation-card">
                                <p class="result-label">Equation</p>
                                <p class="result-value">—</p>
                            </div>

                            <div class="result-card">
                                <p class="result-label">Slope</p>
                                <p class="result-value">—</p>
                            </div>

                            <div class="result-card">
                                <p class="result-label">Y-Intercept</p>
                                <p class="result-value">—</p>
                            </div>

                            <div class="result-card">
                                <p class="result-label">R²</p>
                                <p class="result-value">—</p>
                            </div>

                        </div>
                    </section>

                </div>
            </div>
        </main>
    </div>
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 