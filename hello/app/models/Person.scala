package models

import play.api.libs.json._

/**
 * Person
 * User: Alexandros Bantis
 * Date: 4/17/14
 * Time: 9:02 PM
 */
case class Person(name: String, age: Int)

object Person {

  val persons = List(
    Person("bill", 24),
    Person("alex", 42),
    Person("todd", 36)
  )

  implicit val personToJson =




}
