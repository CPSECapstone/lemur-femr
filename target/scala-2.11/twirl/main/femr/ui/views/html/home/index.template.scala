
package femr.ui.views.html.home

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
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[femr.common.dtos.CurrentUser,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(currentUser: femr.common.dtos.CurrentUser, assets: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import femr.ui.views.html.layouts.main

def /*5.6*/additionalScripts/*5.23*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.27*/("""
        """),format.raw/*6.9*/("""<script type="text/javascript" src=""""),_display_(/*6.46*/assets/*6.52*/.path("js/libraries/handlebars.min.js")),format.raw/*6.91*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*7.46*/assets/*7.52*/.path("js/libraries/typeahead.bundle.min.js")),format.raw/*7.97*/(""""></script>

        <script>
                if (window.location.search.indexOf('feedback=received') > -1) """),format.raw/*10.79*/("""{"""),format.raw/*10.80*/("""
                    """),format.raw/*11.21*/("""$('#feedbackResponse').css("""),format.raw/*11.48*/("""{"""),format.raw/*11.49*/(""""display":"block""""),format.raw/*11.66*/("""}"""),format.raw/*11.67*/(""");
                    setTimeout(function () """),format.raw/*12.44*/("""{"""),format.raw/*12.45*/("""
                        """),format.raw/*13.25*/("""$('#feedbackResponse').show().delay(2000).fadeOut('fast');
                    """),format.raw/*14.21*/("""}"""),format.raw/*14.22*/(""", 2000);
                """),format.raw/*15.17*/("""}"""),format.raw/*15.18*/("""

        """),format.raw/*17.9*/("""</script>

    """)))};def /*22.4*/top/*22.7*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*22.11*/("""
    """),format.raw/*23.5*/("""<div class="jumbotron">
      <div class="container">
        <h2>Welcome to fEMR 2.4.1-beta, """),_display_(/*25.42*/currentUser/*25.53*/.getFirstName),format.raw/*25.66*/("""!</h2>
          <div id="feedbackResponse">Your feedback has been received.</div>
        """),format.raw/*27.120*/("""
        """),format.raw/*28.9*/("""<p>Please select a tab at the top to get started!</p>

        <p>or</p>
        <p>Search Below:</p>
        <div id="patientSearchContainer">
            <input  type="text" class="patientSearch fInput typeahead loading" id="patientSearch" name="patientSearch" placeholder="Loading&hellip;" disabled="disabled"/>
        </div>
      </div>
    </div>
  """)))};
Seq[Any](format.raw/*1.67*/("""

"""),format.raw/*4.1*/("""
    """),format.raw/*19.6*/("""


  """),format.raw/*37.4*/("""

"""),_display_(/*39.2*/main("Home", currentUser, outsideContainerTop = top, scripts = additionalScripts, assets = assets)/*39.100*/ {_display_(Seq[Any](format.raw/*39.102*/("""
  """),format.raw/*44.11*/("""
""")))}),format.raw/*45.2*/("""
"""))
      }
    }
  }

  def render(currentUser:femr.common.dtos.CurrentUser,assets:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,assets)

  def f:((femr.common.dtos.CurrentUser,AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,assets) => apply(currentUser,assets)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Oct 27 21:59:18 PDT 2020
                  SOURCE: C:/Users/Noel/Documents/csc402/lemur-femr/femr/app/femr/ui/views/home/index.scala.html
                  HASH: cad51257be6cf243a453c8c45fcd108eb48ee743
                  MATRIX: 996->1|1134->71|1185->118|1210->135|1290->139|1326->149|1389->186|1403->192|1462->231|1546->289|1560->295|1625->340|1764->451|1793->452|1843->474|1898->501|1927->502|1972->519|2001->520|2076->567|2105->568|2159->594|2267->674|2296->675|2350->701|2379->702|2418->714|2459->741|2470->744|2551->748|2584->754|2708->851|2728->862|2762->875|2884->1079|2921->1089|3326->66|3356->111|3389->732|3424->1455|3455->1460|3563->1558|3604->1560|3636->1655|3669->1658
                  LINES: 28->1|31->3|33->5|33->5|35->5|36->6|36->6|36->6|36->6|37->7|37->7|37->7|40->10|40->10|41->11|41->11|41->11|41->11|41->11|42->12|42->12|43->13|44->14|44->14|45->15|45->15|47->17|49->22|49->22|51->22|52->23|54->25|54->25|54->25|56->27|57->28|67->1|69->4|70->19|73->37|75->39|75->39|75->39|76->44|77->45
                  -- GENERATED --
              */
          