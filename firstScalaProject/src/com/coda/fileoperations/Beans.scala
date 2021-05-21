package com.coda.fileoperations

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Beans {

  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("/Users/vj/bigdata-training/training-files/auth.csv")
    val lines = file.getLines()
    val list=new ListBuffer[AuthBean]
    for (eachLine <- lines) {
      val cols=eachLine.split(",")
      list+=AuthBean(cols(0),cols(2))
    }
    val authBeanList=list.toList
    authBeanList.foreach(each=>println(each.authCode))
  }
}
case class AuthBean(authCode:String,auaCode:String)
// POJO
// Datacarrier
// VO - Value Object
// DTO - Data Transfer Object