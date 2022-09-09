package com.github.plokhotnyuk.jsoniter_scala.macros

import java.nio.charset.StandardCharsets.UTF_8
import java.time._
import java.util.{Objects, UUID}
import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros
import com.github.plokhotnyuk.jsoniter_scala.macros.JsonCodecMaker._
import org.scalatest.exceptions.TestFailedException
import scala.annotation.{switch, experimental}
import scala.util.hashing.MurmurHash3

@experimental
class JsonCodecMakerSpecReduced extends VerifyingSpec {
  import NamespacePollutions._

  //given CodecMakerConfig.PrintCodec with {}
  // implicit val printCodec: CodecMakerConfig.PrintCodec = new CodecMakerConfig.PrintCodec {}

  val codecOfOptionOfInt = make[Option[Int]]

  // val codecOfPrimitives: JsonValueCodec[Primitives] = make

  "JsonCodecMaker.make generate codecs which" should {
    // "serialize and deserialize case classes with primitives" in {
    //   verifySerDeser(codecOfPrimitives, Primitives(1.toByte, 2.toShort, 3, 4L, bl = true, 'V', 1.1, 2.2f),
    //     """{"b":1,"s":2,"i":3,"l":4,"bl":true,"ch":"V","dbl":1.1,"f":2.2}""")
    // }
  }
}

