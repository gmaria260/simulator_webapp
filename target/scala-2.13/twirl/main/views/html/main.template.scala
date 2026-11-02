
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.69*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>"""),_display_(/*6.17*/title),format.raw/*6.22*/("""</title>

        <link rel="stylesheet"
              media="screen"
              href=""""),_display_(/*10.22*/assetsFinder/*10.34*/.path("stylesheets/main.css")),format.raw/*10.63*/("""">

        <link rel="shortcut icon"
              type="image/png"
              href=""""),_display_(/*14.22*/assetsFinder/*14.34*/.path("images/favicon.png")),format.raw/*14.61*/("""">
    </head>

    <body>
        """),_display_(/*18.10*/content),format.raw/*18.17*/("""

        """),format.raw/*20.9*/("""<script src=""""),_display_(/*20.23*/assetsFinder/*20.35*/.path("javascripts/dataTable.js")),format.raw/*20.68*/("""" defer></script>
    </body>
</html>"""))
      }
    }
  }

  def render(title:String,content:Html,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(assetsFinder)

  def f:((String) => (Html) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (assetsFinder) => apply(title)(content)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: a07ac594ca9a58d58c05aeb9a2058f7af480c533
                  MATRIX: 746->1|908->68|938->72|1027->135|1052->140|1174->235|1195->247|1245->276|1366->370|1387->382|1435->409|1502->449|1530->456|1569->468|1610->482|1631->494|1685->527
                  LINES: 21->1|26->1|28->3|31->6|31->6|35->10|35->10|35->10|39->14|39->14|39->14|43->18|43->18|45->20|45->20|45->20|45->20
                  -- GENERATED --
              */
          