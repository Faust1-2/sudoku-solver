// package sudoku

// import scala.collection.mutable
// import scala.util.boundary
// import scala.Console

// class Sudoku(var data: Array[Int]) {
//   def isSolved(): Boolean = ???

//   def isValid(): Boolean = ??? // contains error

//   def readLine(line: Int): Array[Int] = this.data.slice((line * 9), (line * 9) + 9)

//   def readColumn(column: Int): Array[Int] = {
//     return data.zipWithIndex
//       .filter((elem, index) => index % 9 == column)
//       .map((elem, index) => elem)
//   }

//   // def readSquare(square: Int): Array[Int] = {
//   //   return this.data.slice((square - 1) * 3 + 27 * (square / 3), 3 * square + 27 * (square / 3)) ++
//   //     this.data.slice((9 + 3 * (square - 1)) + 27 * (square / 3), 12 + 3 * (square - 1) + 27 * (square / 3)) ++
//   //     this.data.slice((18 + 3 * (square - 1)) + 27 * (square / 3), 21 + 3 * (square - 1) + 27 * (square / 3))
//   // }

//   def readSquare(square: Int): Array[Int] = square.match
//     case 1 => this.data.slice(0, 3) ++ this.data.slice(9, 12) ++ this.data.slice(18, 21)
//     case 2 => this.data.slice(3, 6) ++ this.data.slice(12, 15) ++ this.data.slice(21, 24)
//     case 3 => this.data.slice(6, 9) ++ this.data.slice(15, 18) ++ this.data.slice(24, 27)
//     case 4 => this.data.slice(27, 30) ++ this.data.slice(36, 39) ++ this.data.slice(45, 48)
//     case 5 => this.data.slice(30, 33) ++ this.data.slice(39, 42) ++ this.data.slice(48, 51)
//     case 6 => this.data.slice(33, 36) ++ this.data.slice(42, 45) ++ this.data.slice(51, 54)
//     case 7 => this.data.slice(54, 57) ++ this.data.slice(63, 66) ++ this.data.slice(72, 75)
//     case 8 => this.data.slice(57, 60) ++ this.data.slice(66, 69) ++ this.data.slice(75, 78)
//     case 9 => this.data.slice(60, 63) ++ this.data.slice(69, 72) ++ this.data.slice(78, 81)

//   def readCoordinates(line: Int, column: Int): Int = this.data(column + line * 9)

//   override def toString(): String = {
//     val myString = mutable.StringBuilder()
//     for (y <- 0 to 10) {
//       for (x <- 0 to 8) {
//         if (y == 0) myString.addAll(" ___")
//         else if (y == 10) myString.addAll(" ‾‾‾")
//         else myString.addAll("| %d ".format(data(x + ((y - 1) * 9))))
//       }
//       if (y != 0 && y != 10) myString.addAll("|\n")
//       else myString.addAll("\n")
//     }
//     return myString.toString()
//   }

//   def isInputValid(lineIndex: Int, columnIndex: Int, value: Int): Boolean = {
//     val row = this.readLine(lineIndex)
//     val column = this.readColumn(columnIndex)
//     val square = this.readSquare(findSquare(lineIndex, columnIndex))
//     Console.print(value, !row.contains(value), !column.contains(value), !square.contains(value))
//     return !row.contains(value) && !column.contains(value) && !square.contains(value)
//   }

// }

// def findSquare(lineIndex: Int, columnIndex: Int): Int = {
//   val square_x = (lineIndex / 3).toInt
//   val square_y = (columnIndex / 3).toInt
//   return (square_x + square_y * 3) + 1
// }

// def coordToIndex(lineIndex: Int, columnIndex: Int): Int = 9 * lineIndex + columnIndex

// def solve(sudoku: Sudoku, r: Int = 0, c: Int = 0): Boolean = {
//   print(sudoku)
//   if (r == 9) {
//     return true
//   } else if (c == 9) {
//     return solve(sudoku, r + 1, 0)
//   } else if (sudoku.readCoordinates(r, c) != 0) {
//     return solve(sudoku, r, c + 1)
//   } else {
//     boundary:
//       for (value <- 1 to 9) {
//         if (sudoku.isInputValid(r, c, value)) {
//           sudoku.data(coordToIndex(r, c)) = value
//           if (solve(sudoku, r, c + 1)) {
//             boundary.break(true)
//           }
//           sudoku.data(coordToIndex(r, c)) = 0
//         }
//       }
//       return false
//   }
// }

package sudoku

class Sudoku(grid: Array[Array[Int]]) {

  def readColumn(column: Int): Array[Int] = {
    return grid.map((line) => line(column))
  }
}