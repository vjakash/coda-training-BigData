package com.coda.kafka

import java.util.Properties
import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

object KafkaProducer {

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
    //props.put("partitioner.class", "com.presidio.datascience.fileprocessing.KafkaUserCustomPartitioner")

    val producer = new KafkaProducer[String, String](props)
    val data = new ProducerRecord[String, String]("DATA-TOPIC", "key", "sample-data")
    producer.send(data)
    producer.flush()
  }
}
