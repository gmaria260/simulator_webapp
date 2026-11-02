
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

        <!-- Header -->
        <header class="simulator-header">
            <div class="header-content">

                <div class="simulator-logo">
                    <img
                        src=""""),_display_(/*13.31*/assetsFinder/*13.43*/.path("images/logo.png")),format.raw/*13.67*/(""""
                        alt="Linear Regression Simulator logo"
                    >
                </div>

                <h1>Linear Regression Simulator</h1>

            </div>
        </header>

        <!-- Main content -->
        <main class="simulator-main">

            <section class="simulator-intro">
                <p>
                    Enter X and Y values to compute the formula Y = b0 + b1X.
                    To predict Y, enter only X values.
                </p>
            </section>

            <div class="simulator-workspace">

                <!-- Data input and prediction -->
            <section class="data-panel">

                <!-- Data input heading -->
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

                <!-- Prediction inside the same panel -->
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
                  HASH: e9429c0e08c77f471d2ff60e123723935e1ccf7c
                  MATRIX: 735->1|869->40|899->45|942->80|981->82|1015->90|1283->331|1304->343|1349->367
                  LINES: 21->1|26->1|28->3|28->3|28->3|30->5|38->13|38->13|38->13
                  -- GENERATED --
              */
          