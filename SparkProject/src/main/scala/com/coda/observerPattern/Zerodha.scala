package com.coda.observerPattern

class Zerodha extends Observer {
  def subscribe(nse:NSE): Unit ={
    this.exchange=nse
    this.exchange.attachObserver(this)
  }
  def unSubscribe(nse:NSE): Unit ={
    this.exchange.detachObserver(this)
    this.exchange=null
  }
  override def update(): Unit = {
    println("Zerodha App- Nifty : "+this.exchange.getIndex())
  }
}
