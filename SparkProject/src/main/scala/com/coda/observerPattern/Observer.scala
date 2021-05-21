package com.coda.observerPattern

trait Observer {
  var exchange:NSE=null;
  def update();
}
