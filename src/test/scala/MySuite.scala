import sudoku.Sudoku
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
  test("isSolved") {}

  test("isValid") {
  val invalidRow: List[Int] = List(
      5, 3, 0, 7, 7, 0, 0, 0, 0,
      6, 0, 0, 1, 9, 5, 0, 0, 0,
      0, 9, 8, 0, 0, 0, 0, 6, 0,
      8, 0, 0, 0, 6, 0, 0, 0, 3,
      4, 0, 0, 8, 0, 3, 0, 0, 1,
      7, 0, 0, 0, 2, 0, 0, 0, 6,
      0, 6, 0, 0, 0, 0, 2, 8, 0,
      0, 0, 0, 4, 1, 9, 0, 0, 5,
      0, 0, 0, 0, 8, 0, 0, 7, 0
    )
  val invalidColumn: List[Int] = List(
      5, 3, 0, 2, 7, 0, 0, 0, 0,
      6, 0, 0, 1, 9, 5, 0, 0, 0,
      5, 9, 8, 0, 0, 0, 0, 6, 0,
      8, 0, 0, 0, 6, 0, 0, 0, 3,
      4, 0, 0, 8, 0, 3, 0, 0, 1,
      7, 0, 0, 0, 2, 0, 0, 0, 6,
      0, 6, 0, 0, 0, 0, 2, 8, 0,
      0, 0, 0, 4, 1, 9, 0, 0, 5,
      0, 0, 0, 0, 8, 0, 0, 7, 0
    )
  val invalidSquare: List[Int] = List(
      5, 3, 0, 2, 7, 0, 0, 0, 0,
      6, 0, 0, 1, 9, 5, 0, 0, 0,
      0, 9, 5, 0, 0, 0, 0, 6, 0,
      8, 0, 0, 0, 6, 0, 0, 0, 3,
      4, 0, 0, 8, 0, 3, 0, 0, 1,
      7, 0, 0, 0, 2, 0, 0, 0, 6,
      0, 6, 0, 0, 0, 0, 2, 8, 0,
      0, 0, 0, 4, 1, 9, 0, 0, 5,
      0, 0, 0, 0, 8, 0, 0, 7, 0
    )
  val valid: List[Int] = List(
      5, 3, 0, 2, 7, 0, 0, 0, 0,      
      6, 0, 0, 1, 9, 5, 0, 0, 0,
      0, 9, 2, 0, 0, 0, 0, 6, 0,
      8, 0, 0, 0, 6, 0, 0, 0, 3,
      4, 0, 0, 8, 0, 3, 0, 0, 1,
      7, 0, 0, 0, 2, 0, 0, 0, 6,
      0, 6, 0, 0, 0, 0, 2, 8, 0,
      0, 0, 0, 4, 1, 9, 0, 0, 5,
      0, 0, 0, 0, 8, 0, 0, 7, 0
    )

  val rowSudoku = new Sudoku(invalidRow)
  val columnSudoku = new Sudoku(invalidColumn)
  val squareSudoku = new Sudoku(invalidSquare)
  val validSudoku = new Sudoku(valid)

  assert(!rowSudoku.isValid())
  assert(!columnSudoku.isValid())
  assert(!squareSudoku.isValid())
  assert(validSudoku.isValid())
}


  test("readLine") {}

  test("readColumn") {
    val wantedColumn = 3
    var myList: List[Int] = List()
    var testList: List[Int] = List()
    for (x <- 0 to 80) {
      myList = myList :+ x
      if (x % 9 == wantedColumn) {
        testList = testList :+ x
      }
    }
    val mySudoKu = Sudoku(myList)

    assertEquals(mySudoKu.readColumn(wantedColumn), testList)
  }

  test("readSquare") {
    val sudoku = Sudoku(List.range(0, 81))
    val result = List(30, 31, 32, 39, 40, 41, 48, 49, 50)

    assertEquals(sudoku.readSquare(5), result)
  }

  test("PrettyPrint") {
    var myList: List[Int] = List()
    for (x <- 0 to 80) {
      myList = myList :+ x%9
    }
    val mySudoKu = Sudoku(myList)
    assertNoDiff(
      mySudoKu.toString(),
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

}
