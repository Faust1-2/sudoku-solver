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
}