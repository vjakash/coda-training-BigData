package com.coda.statePattern

class RingMode extends MobileAlertMode {
  override def alert(): Unit = {
    println("The mobile is ringing while alerting....")
  }
}
