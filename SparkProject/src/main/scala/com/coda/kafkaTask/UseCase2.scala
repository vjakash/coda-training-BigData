package com.coda.kafkaTask
import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}
import org.apache.kafka.common.Cluster
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

import java.util.Properties
import java.util

object UseCase2 {

  def main(args : Array[String]) = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("client.id", "PresidioProducer")
    //avroSerializer
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("linger.ms", "1")
    props.put("batch.size","445")
    props.put("compression.codec","1")
    props.put("request.required.acks","-1")
//    props.put("partitioner.class", "com.coda.kafkaTask.KafkaUserCustomPartitioner")
    val callback = new Callback {
      override def onCompletion(recordMetadata: RecordMetadata, e: Exception) = {
        println("LEO - " + recordMetadata.offset())
        println(recordMetadata.topic())
        println(recordMetadata.partition())
      }
    }
    val producer = new KafkaProducer[String, String](props)
    val data = new ProducerRecord[String, String]("QURE-DATA-LINEAGE", "coda-cold", "coda-hot")
    producer.send(data, callback)
    producer.flush()
  }
}
//class KafkaUserCustomPartitioner extends Partitioner {
//   def close(): Unit = {}
//   def configure(map: util.Map[String, _]): Unit = {}
//   def partition(topic: String, key: scala.Any, keybytes: Array[Byte],
//                         value: scala.Any, valuebytes: Array[Byte], cluster: Cluster): Int = {
//    val key_ = key.asInstanceOf[String]
//    if (key_.startsWith("M"))
//      10
//    else if (key_.startsWith("C"))
//      16
//    else
//      19
//  }
//
//  override def numPartitions: Int = 2
//
//  override def getPartition(key: Any): Int = 2
//}