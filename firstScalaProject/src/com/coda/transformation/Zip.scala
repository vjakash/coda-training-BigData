package com.coda.transformation

object Zip {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh")
    val code=List("IND","CHN","PK","NP","BNG","IN")
    val zippedList=list.zip(code)
    val zippedWithIndex=list.zipWithIndex

    println(zippedList)
    println(zippedWithIndex)
  }
}
