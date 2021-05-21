package com.coda.statePattern

class VibrateMode extends MobileAlertMode {
  override def alert(): Unit = {
    println("The mobile is vibrating while alerting....")
  }
}
