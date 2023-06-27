package sudoku

class Sudoku(var data: List[Int]) {
  def isSolved(): Boolean = ???

  def isValid(): Boolean = ??? // contains error

  def readLine(line: Int): List[Int] = ???

  def readColumn(column: Int): List[Int] = {
    var columnList: List[Int] = List()
    for {
      x <- 0 to 80
      if (x % 9 == column)
      y = data(x)
    } yield columnList = columnList :+ y
    return columnList
  }

  def readSquare(square: Int): List[Int] = {
    return this.data.slice((square-1)*3 + 27*(square/3), 3*square + 27*(square/3)) ++
    this.data.slice((9+3*(square-1)) + 27*(square/3), 12+3*(square-1) + 27*(square/3)) ++
    this.data.slice((18+3*(square-1)) + 27*(square/3) , 21+3*(square-1) + 27*(square/3))
  }

  def prettyPrint() = {
    for (y <- 0 to 10) {
      for (x <- 0 to 8) {
        if (y == 0) Console.print(" ___")
        else if (y == 10) Console.print(" ‾‾‾")
        else Console.print("| %d ".format(data(x + ((y - 1) * 9))))
      }
      if (y != 0 && y != 10) Console.print("|\n")
      else Console.print("\n")
    }
  }
}
