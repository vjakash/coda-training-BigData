package com.coda.transformation

object Tail {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
    list.tail.foreach { x => println(x) }

  }
}
