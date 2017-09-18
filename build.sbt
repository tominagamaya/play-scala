name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.json4s" %% "json4s-native" % "3.5.3",
  "org.json4s" %% "json4s-jackson" % "3.5.3",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

