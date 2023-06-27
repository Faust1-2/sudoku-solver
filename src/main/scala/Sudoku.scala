package sudoku

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

    def prettyPrint() = {
        for (y <- 0 to 10) {
            for (x <- 0 to 8) {
                if (y == 0) Console.print(" ___")
                else if (y == 10) Console.print(" ‾‾‾")
                else Console.print("| %d ".format(data(x + ((y-1)*9))))
            }
            if (y != 0 && y != 10) Console.print("|\n")
            else Console.print("\n")
        }
    }
}