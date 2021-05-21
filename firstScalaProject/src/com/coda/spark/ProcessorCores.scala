package com.coda.spark

object ProcessorCores {

  def main(args: Array[String]): Unit = {
    // How many threads
    // no of cores
    // Hyperthreading, OS processor threads
    // local
    // local[*]
    // Yarn - yet another resource negotiator
    // EMR
    // mesos
    // spark
    // kubernetes
    println(Runtime.getRuntime.availableProcessors())
    /*
    $ lscpu
      C:/ windows task manager
    C:/ windows => dxdiag
    $ sysntcl
    */

  }
}
