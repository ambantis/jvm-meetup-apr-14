package controllers

import play.api.mvc.{Action, Controller}

/**
 * Hello
 * User: Alexandros Bantis
 * Date: 4/17/14
 * Time: 8:45 PM
 */
object Hello extends Controller {

  def hello(name: String) = Action {
    val title = "Hello to Playframework"
    Ok(views.html.hello(title, name))
  }

}
