val zioVersion = "2.0.15"
val scala3Version = "3.3.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "sudoku-solver",
    version := "1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "1.0.12",
      "dev.zio" %% "zio-json" % "0.9.3",
      "dev.zio" %% "zio-nio" % "1.1.3"
      // Add other libraries like zio-nio and zip-json here if needed
    ).map(_ % Compile),
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29",
    ).map(_ % Test)
  )