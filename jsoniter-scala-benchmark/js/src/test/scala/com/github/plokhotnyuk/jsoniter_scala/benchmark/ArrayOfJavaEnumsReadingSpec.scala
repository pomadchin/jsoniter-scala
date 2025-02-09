package com.github.plokhotnyuk.jsoniter_scala.benchmark

class ArrayOfJavaEnumsReadingSpec extends BenchmarkSpecBase {
  def benchmark: ArrayOfJavaEnumsReading = new ArrayOfJavaEnumsReading {
    setup()
  }

  "ArrayOfJavaEnumsReading" should {
    "read properly" in {
      benchmark.borer() shouldBe benchmark.obj
      benchmark.circe() shouldBe benchmark.obj
      benchmark.circeJawn() shouldBe benchmark.obj
      benchmark.circeJsoniter() shouldBe benchmark.obj
      benchmark.jsoniterScala() shouldBe benchmark.obj
      benchmark.playJson() shouldBe benchmark.obj
      benchmark.playJsonJsoniter() shouldBe benchmark.obj
      benchmark.uPickle() shouldBe benchmark.obj
    }
    "fail on invalid input" in {
      (0 to 2).foreach { i =>
        val b = benchmark
        b.jsonBytes(i) = 'x'.toByte
        intercept[Throwable](b.borer())
        intercept[Throwable](b.circe())
        intercept[Throwable](b.circeJawn())
        intercept[Throwable](b.circeJsoniter())
        intercept[Throwable](b.jsoniterScala())
        intercept[Throwable](b.playJson())
        intercept[Throwable](b.playJsonJsoniter())
        intercept[Throwable](b.uPickle())
      }
    }
  }
}