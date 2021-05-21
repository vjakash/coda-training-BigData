package com.coda.mementoPattern

object Client {
  def main(args: Array[String]): Unit = {
    val intelij=new IDE
    val myGithub=new Github

    intelij.setCode("val abc=10")//day 1 code

    myGithub.commit(intelij.saveToGit())

    intelij.setCode(":val abc=20")//day 2 code
    intelij.setCode("val abc=30")//day 3 code

    myGithub.commit(intelij.saveToGit())

    val commit1=myGithub.getCommit(0)
    println("code of day 1:"+intelij.getCodeFromCommit(commit1))
  }
}
