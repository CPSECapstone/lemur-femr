// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/noel/Desktop/CPE/femr/femr/conf/routes
// @DATE:Wed Jan 20 18:29:24 PST 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:97
package controllers {

  // @LINE:97
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:97
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
