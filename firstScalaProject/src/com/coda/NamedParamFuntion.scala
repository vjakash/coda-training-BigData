package com.coda

object NamedParamFuntion {
  // Best Practise - Always give default values
  def weaveData(id : Int = 3000, name : String = "CouchDB", isLoggable: Boolean = false) = {
    println(s"Id is $id Name is $name And isLoggable= $isLoggable")
  }
}
