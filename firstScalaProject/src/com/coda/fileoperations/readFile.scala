package com.coda.fileoperations

import scala.io.Source

object readFile {

  def main(args: Array[String]): Unit = {
//    val file = Source.fromFile("/Users/vj/bigdata-training/training-files/auth.csv")
//    val lines = file.getLines()
//    for (eachLine <- lines) {
//      val columns=eachLine.split(",")
////      println(eachLine)
//      println(columns(3)+"-"+columns(6))
//    }

//    Source .fromFile("/Users/vj/bigdata-training/training-files/auth.csv") .foreach { print }
  readCSVFile("/Users/vj/bigdata-training/training-files/auth.csv")
  }
  def readFileMethod1(fileName:String)={
    Source .fromFile(fileName) .foreach { print }
  }
  def readFileMethod2(fileName:String)={
    val file = Source.fromFile("/Users/vj/bigdata-training/training-files/auth.csv")
    val lines = file.getLines()
    for (eachLine <- lines) {
            println(eachLine)
    }
  }
  def readFileMethod3(fileName:String)={
    val file=Source.fromFile(fileName)
    for(line<-file.getLines()){
      println(line)
    }
    file.close()
  }
  def readCSVFile(fileName:String)={
    val bufferedSource = Source.fromFile(fileName)
    for (line <- bufferedSource.getLines()) {
      val cols = line.split(",").map(_.trim)
      println(cols(3))
    }
    bufferedSource.close
  }
}
