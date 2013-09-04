package withjsp

import org.scalatra._
import scalate.ScalateSupport

class App extends Base {

  get("/") {
    <html>
      <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
      </head>
      <body>
        <div class="container">
        <h3>Hello, world!</h3>
        <hr/>
        Say <a href="hello-scalate">hello to Scalate</a>.<br/>
        Visit <a href="/legacy.jsp">/legacy.jsp</a>.<br/>
        </div>
      </body>
    </html>
  }

}
