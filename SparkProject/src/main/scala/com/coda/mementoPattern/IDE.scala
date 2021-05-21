package com.coda.mementoPattern

class IDE {
  private var code:String=""
  def getCode():String={
    code
  }
  def setCode(code:String): Unit ={
    this.code=code
  }
  def saveToGit(): Commit ={
    new Commit(code)
  }
  def getCodeFromCommit(commit:Commit):String={
  commit.getCode()
  }
}
