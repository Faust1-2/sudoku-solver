import sudoku.Sudoku
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MySuite extends munit.FunSuite {

  val sudoKu = Sudoku(List.range(0, 81).map(x => x%9))

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
    var testList: List[Int] = List()
    for (x <- 0 to 80) {
      if (x % 9 == wantedColumn) {
        testList = testList :+ x%9
      }
    }
    assertEquals(sudoKu.readColumn(wantedColumn), testList)
  }

  test("readSquare") {
    val result = List(3, 4, 5, 3, 4, 5, 3, 4, 5)
    assertEquals(sudoKu.readSquare(5), result)
  }

  test("toString") {
    assertNoDiff(
      sudoKu.toString(),
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
    assertEquals(sudoKu.findSquare(0, 0), 0)
    assertEquals(sudoKu.findSquare(4, 2), 1)
    assertEquals(sudoKu.findSquare(2, 4), 3)
    assertEquals(sudoKu.findSquare(7, 5), 5)
    assertEquals(sudoKu.findSquare(5, 8), 7)
  }

}
