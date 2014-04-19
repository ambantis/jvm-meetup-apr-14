
import java.util.ArrayList

val myList: Vector[Int] = Vector(1,2,3,4,5)
val javaArrayList = new ArrayList[Int]()
javaArrayList.add(1)
javaArrayList.add(2)
javaArrayList.add(3)
javaArrayList.add(4)
javaArrayList.add(5)

def mapIntTimesTwoThenToString(l: ArrayList[Int]): ArrayList[String] = {
  val arrayList = new java.util.ArrayList[String]()
  var i = 0
  while (i < l.size) {
    arrayList.add( (2 * l.get(i)).toString )
    i += 1
  }
  arrayList
}




