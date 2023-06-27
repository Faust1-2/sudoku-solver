package sudoku

import scala.collection.mutable

class Sudoku(var data: List[Integer]) {
    def isSolved(): Boolean = ???

    def isValid(): Boolean = ??? // contains error

    def readLine(line: Integer): List[Integer] = ???

    def readColumn(column: Integer): List[Integer] = {
        var columnList: List[Integer] = List()
        for {
            x <- 0 to 80
            if (x % 9 == column)
            y = data(x)
        } yield columnList = columnList :+ y
        return columnList
    }

    def readSquare(square: Integer): List[Integer] = ???

    override def toString(): String = {
        val myString = mutable.StringBuilder()
        for (y <- 0 to 10) {
            for (x <- 0 to 8) {
                if (y == 0) myString.addAll(" ___")
                else if (y == 10) myString.addAll(" ‾‾‾")
                else myString.addAll("| %d ".format(data(x + ((y-1)*9))))
            }
            if (y != 0 && y != 10) myString.addAll("|\n")
            else myString.addAll("\n")
        }
        return myString.toString()
    }
}