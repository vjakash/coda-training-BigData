object filterTransformation {

  def main(args: Array[String]): Unit = {
    val list=List("apple","orange","mango","apricot")
    val filteredList=list.filter(each=>each.startsWith("a"))
    filteredList.foreach(each=>println(each))
  }
}
