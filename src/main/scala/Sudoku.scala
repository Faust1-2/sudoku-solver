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
  
  def isInputValid(x: Int, y: Int, value: Int): Boolean = {
    val isNotInLine = !grid(y).contains(value)
    val isNotInColumn = !grid.map(value => value.apply(x)).contains(value)
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
