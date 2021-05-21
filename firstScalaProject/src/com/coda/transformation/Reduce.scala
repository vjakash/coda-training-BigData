package com.coda.transformation

object Reduce {

  def main(args: Array[String]): Unit = {
    val nums=List(1,2,3,4)
    val result=nums.reduceLeft(_+_)
    println(result)
    val list=List("Hello","World","from","scala")
    val str=list.reduceLeft((x,y)=>x.concat("-").concat(y))
    println(str)
  }
}
