lazy val root = (project in file("."))
  .settings(
    name := "fs2-reactive-button",
    scalaVersion := "2.13.1",
    libraryDependencies ++= Seq(
      "co.fs2" %%% "fs2-core" % "2.2.2"
    )
  )
  .enablePlugins(ScalaJSPlugin)
