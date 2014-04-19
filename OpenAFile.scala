import java.io.{IOException, FileNotFoundException }
import scala.util.{Failure, Success, Try}
import scala.io.{Source,Codec}

object FileUtils {

  def withFile(name: String, codec: Codec = Codec.UTF8)
              (f: Source => String): Try[String] = {
    var src: Source = null
    try {
      src = Source.fromFile(name)(codec)
      Success(f(src))
    } catch {
      case e: Exception => Failure(e)
    } finally {
      if (src != null) src.close
    }
  }
}

object FileService {
  import FileUtils._
  def getLine(fileName: String, n: Int): Try[String] = {
    withFile(fileName) { src =>
      val it = src.getLines
      var i = 1
      while (i < n) it.next
      it.next
    }
  }
}

object Main {
  import FileService._

  def main(fileName: String, n: Int): Unit = {
    getLine(fileName, n) match {
      case Success(line) =>
        println(s"Okay, here's line $n from $fileName:\n\t$line")
      case Failure(e: FileNotFoundException) =>
        println(s"Sorry, the file you requested: $fileName, doesn't exist")
      case Failure(e: IOException) =>
        println(s"Sorry, there's a problem with IO, please try again later")
      case Failure(e: NullPointerException) =>
        println(s"Sorry, but the file name you provided is null")
      case Failure(e: NoSuchElementException) =>
        println(s"Sorry, but the line number you requested: $n, doesn't exist")
      case Failure(e) =>
        println(s"Sorry, there was an Internal Server Error")
        println(e.getStackTraceString)
    }
  }
}
