package com.coda.kafkaTask

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.spark.{SparkConf, SparkContext}

import java.util.Properties

//Northern Trust has credit risk banking platform which publishes data in Kafka in the following topics.
// The platform is called VACE which is responsible for reporting data in FSB-IA and FINREP reports.
//[1] Write the scala producer to feed the data to NORTHERN-VACE topic from auth.csv. Read the auth.csv and feed it into the topic NORTHERN-VACE.
object UseCase1 {

  def main(args: Array[String]): Unit = {
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
    //props.put("partitioner.class", "com.presidio.datascience.fileprocessing.KafkaUserCustomPartitioner")

    val producer = new KafkaProducer[String, String](props)
    val sparkConf = new SparkConf()
    sparkConf.setAppName("CodaDataJOB")
    sparkConf.setMaster("local[*]")
    val sparkContext = new SparkContext(sparkConf)
    val textFileRDD = sparkContext.textFile("/Users/vj/bigdata-training/training-files/auth.csv")

    val collectedElement = textFileRDD.collect()
    collectedElement.foreach(each =>{
      val key=each.split(",")(0)
      val data = new ProducerRecord[String, String]("NORTHERN-VACE", key, each)
      producer.send(data)
    })
    producer.flush()
  }
}
