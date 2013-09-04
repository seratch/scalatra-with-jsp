import withjsp._

// ScalatraBootstrap is the fixed name..
class ScalatraBootstrap extends org.scalatra.LifeCycle {
  override def init(context: javax.servlet.ServletContext) {
    context.mount(new App, "/*")
  }
}
