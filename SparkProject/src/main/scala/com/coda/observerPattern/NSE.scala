package com.coda.observerPattern

import java.util.ArrayList

class NSE {
  val list=new ArrayList[Observer]()
  var index = 1000;
  def getIndex(): Int ={
    index
  }
  def setIndex(ind:Int): Unit ={
    this.index=ind
    notifyAllObserver()
  }
  def attachObserver(observer:Observer): Unit ={
    list.add(observer)
  }
  def detachObserver(observer:Observer): Unit ={
    list.remove(observer)
  }
  def notifyAllObserver(): Unit ={
    list.forEach(each=>{
      each.update()
    })
  }
}
