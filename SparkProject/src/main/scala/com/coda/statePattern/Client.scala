package com.coda.statePattern

object Client {
  def main(args: Array[String]): Unit = {
    val mobile=new Mobile
    mobile.getCall()
    mobile.setState(new VibrateMode)
    mobile.getCall()
    mobile.setState(new SilentMode)
    mobile.getCall()
  }
}
