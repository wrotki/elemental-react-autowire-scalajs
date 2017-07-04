import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSImport}
import org.scalajs.dom
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.html_<^._
import spa.client.ace.Ace
import spa.client.logger._

// Trick scalajsbundler into requiring react dependency
// Otherwise japgolly's imports don't work
//@JSImport("react", JSImport.Default)
//@js.native
//object React extends React

@JSExport("SPAMain")
object SPAMain extends js.JSApp {

  @JSExport
  def main(): Unit = {
    log.warn("Application starting")
    // send log messages also to the server
    //log.enableServerLogging("/logging")
    //log.info("This message goes to server as well")

    // create stylesheet
    //GlobalStyles.addToDocument()

    val NoArgs =
      ScalaComponent.static("No args")(<.div("Hello!"))

    val Hello =
      ScalaComponent.builder[String]("Hello")
        .render_P(name => <.div("Hello there ", name))
        .build

    Hello("Donald von Clownstick the Third")
      .renderIntoDOM(dom.document.getElementById("root"))

    NoArgs().renderIntoDOM(dom.document.getElementById("noargs"))

    Ace.component(Ace.props(
      mode = "javascript",
      theme = "chrome",
      name = "ace", // Unique id of <div>
      width = "100%",
      maxLines = 50,
      //ref = "ace",
      fontSize = 18,
      value = "function main(){ console.log(\"Foo\"); }"
      //    editorProps={{$blockScrolling: Infinity}}
      //      onLoad={(editor) => {
      //      editor.focus();
      //      editor.getSession().setUseWrapMode(true);
      //    }}
    ))()
      .renderIntoDOM(dom.document.getElementById("ace"))
  }
}

