package com.coda.transformation

object Fold {
  def main(args: Array[String]): Unit = {
    val nums=List(1,2,3,4)
    val result=nums.foldLeft(10)(_+_)
    println(result)

    val list=List("Hello","World","from","scala")
    val str=list.foldLeft("The final string is=")((x,y)=>x.concat("-").concat(y))
    println(str)

    val rangeOfNum=1 to 100
    val rangeResult=rangeOfNum.foldLeft(0)((x,y)=>x+y)
    println(rangeResult)
  }
}
