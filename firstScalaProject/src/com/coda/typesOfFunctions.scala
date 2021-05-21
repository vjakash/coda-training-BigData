package com.coda

// Java - Object oriented (Objects)
// Scala - OO + FP (Functions)
// Scala is a less verbose, type inferenced,functional language
object typesOfFunctions {

  def compute(str:String)={
    println(str)
  }


  def main(args: Array[String]): Unit = {
    compute("hello")
    ProcedureFunction.warning("errot occured")

    NamedParamFuntion weaveData(name = "vijay",isLoggable = true,id = 101)
    NamedParamFuntion weaveData(name = "vijay",isLoggable = false)

    SymbolNameFunction +%@%&*-*(10002)
    VariableArgFunction variableArgFuntion("hello","world","from","scala")
  }
}
