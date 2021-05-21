package com.coda.mementoPattern

import java.util

class Github {
  private val list=new util.ArrayList[Commit]()
  def commit(commit:Commit): Unit ={
    list.add(commit)
  }
  def getCommit(index:Int): Commit ={
    list.get(index)
  }
}
