lazy val root = (project in file("."))
  .settings(
    name := "fs2-reactive-button",
    scalaVersion := "2.13.1",
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "co.fs2" %%% "fs2-core" % "2.2.2",
      "org.scala-js" %%% "scalajs-dom" % "0.9.8"
    )
  )
  .enablePlugins(ScalaJSPlugin)
