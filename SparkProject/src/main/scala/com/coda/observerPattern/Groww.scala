package com.coda.observerPattern

class Groww extends Observer {
  def subscribe(nse:NSE): Unit ={
    this.exchange=nse
    this.exchange.attachObserver(this)
  }
  def unSubscribe(nse:NSE): Unit ={
    this.exchange.detachObserver(this)
    this.exchange=null
  }
  override def update(): Unit = {
    println("Groww App - Nifty : "+this.exchange.getIndex())
  }
}
