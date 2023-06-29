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
        else myString.addAll("| %d ".format(grid(line-1)(value)))
      }
      if (line != 0 && line != 10) myString.addAll("|\n")
      else myString.addAll("\n")
    }
    return myString.toString()
  }
  
  def isValid(): Boolean = {
    def hasDuplicates(list: List[Int]): Boolean = {
      val filteredList = list.filter(_ != 0)
      filteredList.distinct.size != filteredList.size
    }

    def checkRows(): Boolean = {
      (0 until 9).foreach { row =>
        if (hasDuplicates(readLine(row))) {
          println(s"Duplicate value in row $row")
          return false
        }
      }
      true
    }

    def checkColumns(): Boolean = {
      (0 until 9).foreach { column =>
        if (hasDuplicates(readColumn(column))) {
          println(s"Duplicate value in column $column")
          return false
        }
      }
      true
    }

    def checkSquares(): Boolean = {
      (0 until 9).foreach { square =>
        if (hasDuplicates(readSquare(square))) {
          println(s"Duplicate value in square $square")
          return false
        }
      }
      true
    }

    checkRows() && checkColumns() && checkSquares()
  }
  
  def readColumn(column: Int): Array[Int] = {
    return grid.map((line) => line(column))
  }

  def findSquare(x: Int, y: Int): Int = {
    val square_x = x / 3
    val square_y = y / 3
    return square_x + square_y*3
  }
  
  def isInputValid(x: Int, y: Int, value: Int): Boolean = {
    val isNotInLine = !grid(y).contains(value)
    val isNotInColumn = !readColumn(x).contains(value)
    val boxLine = x / 3
    val boxColumn = y / 3

    val box = for {
      yB <- (boxColumn * 3) until (boxColumn * 3 + 3)
      xB <- (boxLine * 3) until (boxLine * 3 + 3)
    } yield grid(yB)(xB)

    val isNotInBox = !box.contains(value)

    return isNotInBox && isNotInColumn && isNotInLine
  }

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
