package com.coda.statePattern
class Mobile {
  var currentState: MobileAlertMode = new RingMode;
  def getState()={
    currentState
  }
  def setState(mode: MobileAlertMode)={
    currentState=mode;
  }
  def getCall(): Unit ={
    currentState.alert()
  }
}
