object DataJob {
  // void - java
  // unit - scala
  def main(args : Array[String]) = {
    val result=compute(1001,"Hbase")
    println(result)
    println("Job Running")
  }
  def compute(id:Int,dataValue:String):String={
    val noSql="cassandra"
    println("Id is -"+id+" value is -"+dataValue)
    return noSql+"_"+dataValue
  }
}
