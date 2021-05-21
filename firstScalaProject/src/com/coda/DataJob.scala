package com.coda

object DataJob {

  def main(args: Array[String]): Unit = {
    //val dataProcessing1 = new DataProcessingReckoner();
    //val dataProcessing2 = new DataProcessingReckoner()
    val dataProcessor=new DataProcessingReckoner
    //dataProcessor.computeBigData("OracleDB")
    dataProcessor computeBigData "OracleDB"
  }
}
