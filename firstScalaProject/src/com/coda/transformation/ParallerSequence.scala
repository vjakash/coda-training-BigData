package com.coda.transformation

object ParallerSequence {
  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
//    println(list.par)
    list.par.foreach(println)
  }
}
