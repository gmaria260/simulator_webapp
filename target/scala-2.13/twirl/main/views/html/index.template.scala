
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.41*/("""

"""),_display_(/*3.2*/main("Linear Regression Simulator")/*3.37*/ {_display_(Seq[Any](format.raw/*3.39*/("""

    """),format.raw/*5.5*/("""<div class="simulator">

        <header class="simulator-header">
            <div class="header-content">

                <div class="simulator-logo">
                    <img
                        src=""""),_display_(/*12.31*/assetsFinder/*12.43*/.path("images/logo.png")),format.raw/*12.67*/(""""
                        alt="Linear Regression Simulator logo"
                    >
                </div>

                <h1>Linear Regression Simulator</h1>

            </div>
        </header>
        <main class="simulator-main">

            <section class="simulator-intro">
                <p>
                    Enter X and Y values to compute the formula Y = b0 + b1X.
                    To predict Y, enter only X values.
                </p>
            </section>

            <div class="simulator-workspace">

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
                    <span>Dataset <span id="rowCount">1 row</span></span>
                    <div class="table-actions">
                        <input
                            id="csvFileInput"
                            type="file"
                            accept=".csv,text/csv"
                            hidden
                        >
                        <button type="button" id="importCsvButton" class="table-action-button">
                            Import CSV
                        </button>
                        <button type="button" id="addRowButton" class="table-action-button">
                            Add row
                        </button>
                    </div>
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
                    Add rows with the button or press Enter in the last cell. CSV files should have X and Y in the first two columns; a header row is optional.
                </p>
                <p id="importMessage" class="feedback-message" role="status" aria-live="polite"></p>

                <button type="button" class="calculate-button">
                    Calculate Regression
                </button>
                <p id="calculationMessage" class="feedback-message" role="alert" aria-live="polite"></p>

                <div class="prediction-section">

                    <h2>Predict Y</h2>

                    <p class="section-description">
                        Enter an X value to predict its corresponding Y.
                    </p>

                    <div class="prediction-input">

                        <label for="predictionX">X value</label>

                        <input
                            type="number"
                            id="predictionX"
                            step="any"
                            placeholder="Enter X"
                        >

                        <button type="button" id="predictButton">
                            Predict
                        </button>

                    </div>

                    <div class="prediction-result">
                        <span>Predicted Y:</span>
                        <strong id="predictedY">—</strong>
                    </div>
                    <p id="predictionMessage" class="feedback-message" role="status" aria-live="polite"></p>

                </div>

            </section>

                <!-- Graph and results -->
                <div class="visualization-column">

                    <section class="graph-panel">

                        <div class="panel-heading">
                            <div>
                                <h2>Graph</h2>

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

                                <g id="graphTicks" class="graph-ticks"></g>
                                <g id="regressionPlot"></g>

                                <g class="graph-labels">
                                    <text id="xAxisLabel" x="420" y="425" text-anchor="middle">
                                        X
                                    </text>

                                    <text
                                        id="yAxisLabel"
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
                                <p id="equationResult" class="result-value">—</p>
                            </div>

                            <div class="result-card">
                                <p class="result-label">Slope</p>
                                <p id="slopeResult" class="result-value">—</p>
                            </div>

                            <div class="result-card">
                                <p class="result-label">Y-Intercept</p>
                                <p id="interceptResult" class="result-value">—</p>
                            </div>

                            <div class="result-card">
                                <p class="result-label">R²</p>
                                <p id="rSquaredResult" class="result-value">—</p>
                            </div>

                        </div>
                    </section>

                </div>
            </div>

        </main>
    </div>
""")))}))
      }
    }
  }

  def render(assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply()(assetsFinder)

  def f:(() => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = () => (assetsFinder) => apply()(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: d1d0cfeaf514d335f50945e4d3ab0a44f4d7fbe6
                  MATRIX: 735->1|869->40|899->45|942->80|981->82|1015->90|1258->306|1279->318|1324->342
                  LINES: 21->1|26->1|28->3|28->3|28->3|30->5|37->12|37->12|37->12
                  -- GENERATED --
              */
          