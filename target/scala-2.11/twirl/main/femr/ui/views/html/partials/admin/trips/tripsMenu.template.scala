
package femr.ui.views.html.partials.admin.trips

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
/*1.2*/import femr.ui.controllers.admin.routes.TripController

object tripsMenu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<div class="tripOptionsWrap">
    <a href=""""),_display_(/*4.15*/TripController/*4.29*/.manageGet()),format.raw/*4.41*/("""" class="fButton fOtherButton fAdminButton userBtns"><span class="glyphicon glyphicon-plus-sign"></span>
        Manage Trips</a>
    <a href=""""),_display_(/*6.15*/TripController/*6.29*/.teamsGet()),format.raw/*6.40*/("""" class="fButton fOtherButton fAdminButton userBtns"><span class="glyphicon glyphicon-plus-sign"></span>
        Manage Teams</a>
    <a href=""""),_display_(/*8.15*/TripController/*8.29*/.citiesGet()),format.raw/*8.41*/("""" class="fButton fOtherButton fAdminButton userBtns"><span class="glyphicon glyphicon-plus-sign"></span>
        Manage Cities</a>
</div>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Oct 27 21:59:18 PDT 2020
                  SOURCE: C:/Users/Noel/Documents/csc402/lemur-femr/femr/app/femr/ui/views/partials/admin/trips/tripsMenu.scala.html
                  HASH: 5cca976aa1c13f0c0265464bc08f3c8c1749eb78
                  MATRIX: 680->1|1125->59|1196->104|1218->118|1250->130|1422->276|1444->290|1475->301|1647->447|1669->461|1701->473
                  LINES: 24->1|34->3|35->4|35->4|35->4|37->6|37->6|37->6|39->8|39->8|39->8
                  -- GENERATED --
              */
          