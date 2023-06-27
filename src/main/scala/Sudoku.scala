package sudoku

class Sudoku(var data: List[Integer]) {
    def isSolved(): Boolean = ???

    def isValid(): Boolean = ??? // contains error

    def readLine(line: Integer): List[Integer] = ???

    def readColumn(column: Integer): List[Integer] = {
        return data.zipWithIndex
            .filter((elem, index) => index % 9 == column)
            .map((elem, index) => elem)
    }

    def readSquare(square: Integer): List[Integer] = ???
}