

object main extends App{


  // Problem 1: Recursive message printing
  class Msg (val id: Int, val parent: Option[Int], val txt: String)

  def printMessages(messages: Array[Msg]): Unit = {
    def printFrag(parent: Option[Int], indent: String): Unit = {
      for (msg <- messages if msg.parent == parent) {
        println(s"$indent#${msg.id} ${msg.txt}")
        printFrag(Some(msg.id), indent + "  ")
      }
    }
    printFrag(None, "")
  }

  // Problem 2: Rendering a sudoku
  def renderSudoku(lines: Array[Array[Int]]): Unit = {

    def printHorizontal(): Unit = {
      println("+---------+---------+---------+")
    }
    // Iterating through each row
    for (column_index <- lines.indices) {
      if (column_index % 3 == 0) { // Row completed
        printHorizontal()
      }
      // iterating through the row
      for (row_index <- lines(0).indices) {
        if (row_index % 3 == 0) { // Beginning another square
          print("/")
        }
        val number: Int = lines(column_index)(row_index)
        print(s" $number ")
      }
      println("")
    }
    printHorizontal()
  }

  // Problem 3: Printing a list of student ranks
  def studentList(): Unit = {
    val ranks: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (rank <- ranks) {
      if (rank > 4 && rank != 8) {
        println(s"Student rank is: $rank")
      }
    }
  }

  //####### Method demonstrations #######//

  // Problem 1
  printMessages(Array(
    new Msg(0, None, "Line 1"),
    new Msg(1, Some(0), "line 2"),
    new Msg(2, None, "line 3"),
    new Msg(3, Some(2), "line 4"),
    new Msg(4, Some(2), "line 5"),
    new Msg(5, Some(2), "line 6"),
    new Msg(6, Some(5), "line 7"),
  ))

  // Problem 2
  renderSudoku(Array(
    Array(3, 1, 6,  5, 7, 8,  4, 9 ,2),
    Array(5, 2, 9,  1, 3, 4,  7, 9 ,2),
    Array(3, 1, 6,  5, 7, 8,  4, 9 ,2),

    Array(3, 3, 4,  5, 6, 7,  8, 9 ,9),
    Array(4, 5, 6,  5, 7, 8,  4, 9 ,2),
    Array(5, 1, 6,  5, 7, 8,  4, 9 ,2),

    Array(6, 7, 8,  9, 7, 8,  4, 9 ,2),
    Array(7, 1, 9,  5, 3, 3,  3, 3, 3),
    Array(8, 1, 6,  5, 7, 8,  4, 9 ,2)
  ))

  // Problem 3
  studentList()

}
