package com.coda.statePattern

class SilentMode extends MobileAlertMode {
  override def alert(): Unit = {
    println("The mobile is silent while alerting....")
  }
}
