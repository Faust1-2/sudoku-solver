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

  def readSquare(square: Int): List[Int] = square.match
    case 1 => this.data.slice(0, 3) ++ this.data.slice(9, 12) ++ this.data.slice(18, 21)
    case 2 => this.data.slice(3, 6) ++ this.data.slice(12, 15) ++ this.data.slice(21, 24)
    case 3 => this.data.slice(6, 9) ++ this.data.slice(15, 18) ++ this.data.slice(24, 27)
    case 4 => this.data.slice(27, 30) ++ this.data.slice(36, 39) ++ this.data.slice(45, 48)
    case 5 => this.data.slice(30, 33) ++ this.data.slice(39, 42) ++ this.data.slice(48, 51)
    case 6 => this.data.slice(33, 36) ++ this.data.slice(42, 45) ++ this.data.slice(51, 54)
    case 7 => this.data.slice(54, 57) ++ this.data.slice(63, 66) ++ this.data.slice(72, 75)
    case 8 => this.data.slice(57, 60) ++ this.data.slice(66, 69) ++ this.data.slice(75, 78)
    case 9 => this.data.slice(60, 63) ++ this.data.slice(69, 72) ++ this.data.slice(78, 81)

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
