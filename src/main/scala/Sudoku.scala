package sudoku

import scala.collection.mutable
import scala.util.boundary

class Sudoku(grid: Array[Array[Int]]) {

  override def toString(): String = {
    val myString = mutable.StringBuilder()
    for (line <- 0 to 10) {
      for (value <- 0 to 8) {
        if (line == 0) myString.addAll(" ___")
        else if (line == 10) myString.addAll(" ‾‾‾")
        else if (grid(line - 1)(value) != 0) myString.addAll("| %d ".format(grid(line - 1)(value)))
        else myString.addAll("|   ")
      }
      if (line != 0 && line != 10) myString.addAll("|\n")
      else myString.addAll("\n")
    }
    return myString.toString()
  }

  /**
    * isValid is a function that checks if the sudoku grid can be solved.
    * It checks if there is a duplicate value in any columns, lines, or boxes.
    * @return true if valid, false if not
    */
  def isValid(): Boolean = {
    def hasDuplicates(list: Array[Int]): Boolean = {
      val filteredList = list.filter(_ != 0)
      filteredList.distinct.size != filteredList.size
    }

    def checkRows(): Boolean = {
      boundary:
        (0 until 9).foreach { row =>
          if (hasDuplicates(readLine(row))) {
            println(s"Duplicate value in row $row")
            boundary.break(false)
          }
        }
        true
    }

    def checkColumns(): Boolean = {
      boundary:
        (0 until 9).foreach { column =>
          if (hasDuplicates(readColumn(column))) {
            println(s"Duplicate value in column $column")
            boundary.break(false)
          }
        }
        true
    }

    def checkSquares(): Boolean = {
      boundary:
        List((0, 0), (0, 3), (0, 6), (3, 0), (3, 3), (3, 6), (6, 0), (6, 3), (6, 6)).foreach { (x, y) =>
          if (hasDuplicates(readSquare(x, y))) {
            println(s"Duplicate value in square $x , $y")
            boundary.break(false)
          }
        }
        true
    }

    checkRows() && checkColumns() && checkSquares()
  }

  /**
    * A function that retrieve the specified column from the sudoku grid.
    * @param column The index of the column to retrieve. Min : 0 - Max : 8
    * @return Array[Int] corresponding to the values of the column.
    */
  def readColumn(column: Int): Array[Int] = {
    return grid.map((line) => line(column))
  }

  /**
    * A function that retrieve the specified line from the sudoku grid.
    * @param line The index of the line to retrieve. Min : 0 - Max : 8
    * @return Array[Int] corresponding to the values of the line.
    */
  def readLine(line: Int): Array[Int] = grid(line)

  /**
    * A function that retrieve the specified box from the sudoku grid.
    * @param x The index of the column you want to find the box from. Min : 0 - Max : 8
    * @param y The index of the line you want to find the box from. Min : 0 - Max : 8
    * @return Array[Int] corresponding to the values of the box.
    */
  def readSquare(x: Int, y: Int): Array[Int] = {
    val boxLine = x / 3
    val boxColumn = y / 3

    val box = for {
      yB <- (boxColumn * 3) until (boxColumn * 3 + 3)
      xB <- (boxLine * 3) until (boxLine * 3 + 3)
    } yield grid(yB)(xB)

    return box.toArray
  }

  /**
    * Function that checks if a value can be added to the grid at a specified position.
    * @param x the column index of the value you want to add.
    * @param y the line index of the value you want to add.
    * @param value - the value to check.
    * @return true if the value can be added, false if not.
    */
  def isInputValid(x: Int, y: Int, value: Int): Boolean = {
    val isNotInLine = !readLine(y).contains(value)
    val isNotInColumn = !readColumn(x).contains(value)
    val isNotInBox = !readSquare(x, y).contains(value)

    return isNotInBox && isNotInColumn && isNotInLine
  }

  /**
    * The solving function of the sudoku. Uses a "back-tracking" algorithm to try all the possibilities recursively.
    * @param x the current column index of the grid, initialized at 0.
    * @param y the current line index of the grid, initialized at 0.
    * @return true if the a value can be added to the case, false if not. 
    */
  def solve(x: Int = 0, y: Int = 0): Boolean = {
    if (y == 9) {
      print(this)
      return true
    } else if (x == 9) return solve(0, y + 1)
    else if (grid(y)(x) != 0) return solve(x + 1, y)
    else
      boundary:
        for (value <- 1 to 9) {
          if (isInputValid(x, y, value)) {
            grid(y)(x) = value
            if (solve(x + 1, y)) boundary.break(true)
            grid(y)(x) = 0
          }
        }
    return false
  }
}