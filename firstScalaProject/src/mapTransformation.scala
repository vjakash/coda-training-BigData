object mapTransformation {

  def main(args: Array[String]): Unit = {
    val list=List("apple","orange","mango","apricot")
    val mappedList=list.map(each=>format(each))
    mappedList.foreach(each=>println(each))
  }
  def format(item:String):String={
    item.concat("_juice")
  }
}
