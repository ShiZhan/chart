name := "chart"

version := "1.0"

scalaVersion := Option(System.getProperty("scala.version")).getOrElse("2.11.2")

libraryDependencies ++= Seq(
  "com.github.wookietreiber" %% "scala-chart" % "latest.integration",
  "com.lowagie" % "itext" % "4.2.1"
)
