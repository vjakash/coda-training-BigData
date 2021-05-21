package com.coda

object VariableArgFunction {
  // Function with variable number of arguments
  def variableArgFuntion(arg : String*) = {
    for (each <- arg) {
      print(each+"\t")
    }
  }
}
