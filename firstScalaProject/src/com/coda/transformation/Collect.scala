package com.coda.transformation

object Collect {

  def main(args: Array[String]): Unit = {
    val partialFunction : PartialFunction[String, String] = {
      case eachElement: String =>eachElement.concat(" - CHOLA")
    }
    val list = List ("CHERA", "PANDYA", "PALLAVA")
    list .collect(partialFunction).foreach(eachElement => println(eachElement));
  }
}
