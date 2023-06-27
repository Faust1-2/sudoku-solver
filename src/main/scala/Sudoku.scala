package sudoku

import scala.collection.mutable

class Sudoku(var data: List[Int]) {
  def isSolved(): Boolean = ???

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

  def readLine(line: Int): List[Int] = this.data.slice((line* 9), (line * 9) + 9)

  def readColumn(column: Int): List[Int] = {
    return data.zipWithIndex
      .filter((elem, index) => index % 9 == column)
      .map((elem, index) => elem)
  }

  def readSquare(square: Int): List[Int] = {
    return this.data.slice((square-1)*3 + 27*(square/3), 3*square + 27*(square/3)) ++
    this.data.slice((9+3*(square-1)) + 27*(square/3), 12+3*(square-1) + 27*(square/3)) ++
    this.data.slice((18+3*(square-1)) + 27*(square/3) , 21+3*(square-1) + 27*(square/3))
  }

  def findSquare(x: Int, y: Int): Int = {
    val square_x = (x / 3).toInt
    val square_y = (y / 3).toInt
    return square_x + square_y*3
  }

  override def toString(): String = {
    val myString = mutable.StringBuilder()
    for (y <- 0 to 10) {
      for (x <- 0 to 8) {
        if (y == 0) myString.addAll(" ___")
        else if (y == 10) myString.addAll(" ‾‾‾")
        else myString.addAll("| %d ".format(data(x + ((y - 1) * 9))))
      }
      if (y != 0 && y != 10) myString.addAll("|\n")
      else myString.addAll("\n")
    }
    return myString.toString()
  }
}
