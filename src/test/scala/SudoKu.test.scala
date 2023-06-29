import sudoku.Sudoku

class MySuite extends munit.FunSuite {

  var sudokuMatrix = Array[Array[Int]]()

  for(x <- 0 to 8) {
    var sudokuLine = Array[Int]()
    for(y <- 0 to 8) {
      sudokuLine = sudokuLine :+ y
    }
    sudokuMatrix = sudokuMatrix :+ sudokuLine
  }

  val sudokuTable = Sudoku(sudokuMatrix)

  test("isValid") {}

  test("isSolved") {}

  test("readLine") {}

  test("readColumn") {
    val wantedColumn = 3
    var testList = Array[Int]()
    for (x <- 0 to 80) {
      if (x % 9 == wantedColumn) {
        testList = testList :+ x%9
      }
    }
    assertEquals(sudokuTable.readColumn(wantedColumn), testList)
  }

  test("readSquare") {
    val result = Array(3, 4, 5, 3, 4, 5, 3, 4, 5)
    assertEquals(sudokuTable.readSquare(5), result)
  }

  test("toString") {
    assertNoDiff(
      sudokuTable.toString(),
      """ ___ ___ ___ ___ ___ ___ ___ ___ ___
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
 ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾"""
    )
  }

  test("findSquare") {
    assertEquals(sudokuTable.findSquare(0, 0), 0)
    assertEquals(sudokuTable.findSquare(4, 2), 1)
    assertEquals(sudokuTable.findSquare(2, 4), 3)
    assertEquals(sudokuTable.findSquare(7, 5), 5)
    assertEquals(sudokuTable.findSquare(5, 8), 7)
  }
}
