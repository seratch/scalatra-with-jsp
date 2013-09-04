import sbt._
import Keys._
import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import com.mojolly.scalate.ScalatePlugin._
import ScalateKeys._

object ScalatraWithJspBuild extends Build {
  val Organization = "com.github.seratch"
  val Name = "Scalatra with JSP"
  val Version = "0.1.0-SNAPSHOT"
  val ScalaVersion = "2.10.2"
  val ScalatraVersion = "2.2.1"
  val JettyVersion = "8.1.8.v20121106"

  lazy val project = Project (
    "scalatra-with-jsp",
    file("."),
    settings = Defaults.defaultSettings ++ ScalatraPlugin.scalatraWithJRebel ++ scalateSettings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        "org.scalatra"      %% "scalatra"           % ScalatraVersion,
        "org.scalatra"      %% "scalatra-scalate"   % ScalatraVersion,
        "javax.servlet.jsp" %  "jsp-api"            % "2.2"                 % "runtime",
        "javax.servlet"     %  "jstl"               % "1.2"                 % "runtime",
        "org.scalatra"      %% "scalatra-specs2"    % ScalatraVersion       % "test",
        "ch.qos.logback"    % "logback-classic"     % "1.0.13"              % "runtime",
        "org.eclipse.jetty" % "jetty-webapp"        % JettyVersion          % "container",
        "org.eclipse.jetty" % "jetty-jsp"           % JettyVersion          % "container",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
      ),
      scalateTemplateConfig in Compile <<= (sourceDirectory in Compile){ base =>
        Seq(
          TemplateConfig(
            base / "webapp" / "WEB-INF" / "templates",
            Seq.empty,  /* default imports should be added here */
            Seq(
              Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true)
            ),  /* add extra bindings here */
            Some("templates")
          )
        )
      }
    )
  )
}
