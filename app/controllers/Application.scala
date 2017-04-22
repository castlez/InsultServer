package controllers

import java.io.{FileNotFoundException, FileWriter}

import play.api.mvc._

import scala.io.Source
import scala.util.Random

object Application extends Controller {

  def saveInsult = Action { implicit request =>
    val insult = request.body.asText.get
    val fw = new FileWriter("insults.txt", true)
    try {
      fw.write(insult + "\n")
      Ok("Success. Saving insult: " + insult + "\n")
    }
    finally fw.close()
  }

  def randomInsult = Action {
    try{
      var insults =
        Source.fromFile("insults.txt").getLines().toList
      var ins = insults(new Random(System.currentTimeMillis()).nextInt(insults.length))
      Ok(insults(new Random(System.currentTimeMillis()).nextInt(insults.length)))
    } catch {
        case fnf: FileNotFoundException => {
          fnf.printStackTrace()
          Ok("No insult file, you're not cool enough\n")
        }
    }
  }
}
