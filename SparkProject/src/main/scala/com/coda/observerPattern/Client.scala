package com.coda.observerPattern

object Client {
  def main(args: Array[String]): Unit = {
    val nse=new NSE
    val zerodha=new Zerodha()
    zerodha.subscribe(nse)
    new Upstox().subscribe(nse)
    new Groww().subscribe(nse)

    nse.setIndex(14279)
    println("***************")
    nse.setIndex(12507)
    println("***************")
    nse.setIndex(12698)
    println("***************")

    zerodha.unSubscribe(nse)

    nse.setIndex(12789)
    println("***************")
  }
}
