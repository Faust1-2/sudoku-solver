package sudoku

class Sudoku(var data: List[Integer]) {
  def isSolved(): Boolean = ???

  def isValid(): Boolean = ??? // contains error

  def readLine(line: Integer): List[Integer] =
    this.data.slice((line) * 9, (line + 1) * 9)

  def readColumn(column: Integer): List[Integer] = {
    var columnList: List[Integer] = List()
    for {
      x <- 0 to 80
      if (x % 9 == column)
      y = data(x)
    } yield columnList = columnList :+ y
    return columnList
  }

  def readSquare(square: Integer): List[Integer] = square.match
    case 1 => this.data.slice(0, 3) ++ this.data.slice(9, 12) ++ this.data.slice(18, 21)
    case 2 => this.data.slice(3, 6) ++ this.data.slice(12, 15) ++ this.data.slice(21, 24)
    case 3 => this.data.slice(6, 9) ++ this.data.slice(15, 18) ++ this.data.slice(24, 27)
    case 4 => this.data.slice(27, 30) ++ this.data.slice(36, 39) ++ this.data.slice(45, 48)
    case 5 => this.data.slice(30, 33) ++ this.data.slice(39, 42) ++ this.data.slice(48, 51)
    case 6 => this.data.slice(33, 36) ++ this.data.slice(42, 45) ++ this.data.slice(51, 54)
    case 7 => this.data.slice(54, 57) ++ this.data.slice(63, 66) ++ this.data.slice(72, 75)
    case 8 => this.data.slice(57, 60) ++ this.data.slice(66, 69) ++ this.data.slice(75, 78)
    case 9 => this.data.slice(60, 63) ++ this.data.slice(69, 72) ++ this.data.slice(78, 81)
}
