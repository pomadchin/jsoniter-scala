lazy val root = project
  .in(file("."))
  .aggregate(`jsoniter-scala-examplesJVM`, `jsoniter-scala-examplesNative`)

val `jsoniter-scala-examples` = crossProject(JVMPlatform, NativePlatform)
  .crossType(CrossType.Pure)
  .in(file("."))
  .settings(
    scalaVersion := "2.13.8",
    scalacOptions ++= Seq("-Xmacro-settings:print-codecs"),
    crossScalaVersions := Seq("3.1.3", "2.13.8", "2.12.16"),
    Compile / mainClass := Some("com.github.plokhotnyuk.jsoniter_scala.examples.Example01"),
    assembly / mainClass := Some("com.github.plokhotnyuk.jsoniter_scala.examples.Example01"),
    libraryDependencySchemes += "com.github.plokhotnyuk.jsoniter-scala" %%% "jsoniter-scala-core" % "always",
    libraryDependencies ++= Seq(
      "com.github.plokhotnyuk.jsoniter-scala" %%% "jsoniter-scala-core" % "2.17.1",
      // Use the "provided" scope instead when the "compile-internal" scope is not supported
      "com.github.plokhotnyuk.jsoniter-scala" %%% "jsoniter-scala-macros" % "2.17.1" % "compile-internal"
    )
  )

lazy val `jsoniter-scala-examplesJVM` = `jsoniter-scala-examples`.jvm
  .enablePlugins(NativeImagePlugin)
  .settings(
    nativeImageOptions ++= List("--no-fallback", "--initialize-at-build-time", "--diagnostics-mode"),
    nativeImageVersion := "22",
  )

lazy val `jsoniter-scala-examplesNative` = `jsoniter-scala-examples`.native
  .settings(
    nativeMode := "release-full",
    nativeLTO := "thin"
  )
