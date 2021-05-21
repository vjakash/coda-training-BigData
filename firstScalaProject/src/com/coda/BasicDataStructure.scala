package com.coda

object BasicDataStructure {

  def main(args: Array[String]): Unit = {
    val dataList = List("NoSQL", "Voldemort", "Hbase", "Cassandra", "CouchDB")

    val dataSet = Set("NoSQL", "Voldemort", "Voldemort", "Hbase", "Cassandra", "CouchDB")
//    dataSet.foreach(each => println(each))

    val dataTuple = ("NoSQL", "Voldemort", "Voldemort", "Hbase", "Cassandra", "CouchDB")
//    println(dataTuple._1)
    val dataMap = Map("DocumentStoreKey" -> "DocumentStore", 10002.4f -> dataList, dataSet -> "KV Cache",dataTuple->10002)
//    println("Keys")
//    dataMap.foreach(each => println(each._1))
//    println("Values")
//    dataMap.foreach(each => println(each._2))
//    println(dataMap.get(Set("NoSQL", "Voldemort", "Voldemort", "Hbase", "Cassandra", "CouchDB")))
//    println(dataMap.get(10002.4f))
  }
}
