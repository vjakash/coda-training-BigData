package com.coda.transformation

object Scan {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    val result=list.reduceLeft(add)
    println(result)
    val result1=list.foldLeft("Z")(add)
    println(result1)
    val result2=list.scanLeft("Z")(add)
    println(result2)

  }
  def add(x:String, y:String): String = {
    x.concat(" - " + y)
  }
}
