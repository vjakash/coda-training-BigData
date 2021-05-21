package com.coda.transformation

object Filter {

  def main(args: Array[String]): Unit = {
    val list=List("India","China","Pakistan","Nepal","Bangladesh","Indonesia")
//    val filteredList=list.filter(each=>each.startsWith("I"))
//val filteredList=list. filter { (x:String) => x.startsWith("B") }
val filteredList=list. filter ( _.startsWith("I") )
    println(filteredList)
  }
}
