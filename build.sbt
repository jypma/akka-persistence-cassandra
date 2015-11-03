organization := "com.github.krasserm"

name := "akka-persistence-cassandra"

version := "0.5-jypma-201511031129"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

scalaVersion := "2.11.6"

fork in Test := true

javaOptions in Test += "-Xmx2500M"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked",
  "-deprecation",
  //"-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Xfuture"
)

parallelExecution in Test := false

libraryDependencies ++= Seq(
  "com.datastax.cassandra"  % "cassandra-driver-core"             % "2.1.5",
  "com.typesafe.akka"      %% "akka-persistence"                  % "2.4.0",
  "com.typesafe.akka"      %% "akka-persistence-tck"              % "2.4.0"      % "test",
  "org.scalatest"          %% "scalatest"                         % "2.1.4"      % "test",
  "org.cassandraunit"       % "cassandra-unit"                    % "2.1.9.2"    % "test"
)

