import sudoku.Sudoku
import java.io.ByteArrayOutputStream
import java.io.PrintStream

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

  test("isSolved") {}

  test("isValid") {
  val invalidRow: Array[Array[Int]] = Array(
      Array(5, 3, 0, 7, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 0)
    )
  val invalidColumn: Array[Array[Int]] = Array(
      Array(5, 3, 0, 2, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(5, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 0)
    )
  val invalidSquare: Array[Array[Int]] = Array(
      Array(5, 3, 0, 2, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 5, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 0)
    )
  val valid: Array[Array[Int]] = Array(
      Array(5, 3, 0, 2, 7, 0, 0, 0, 0),      
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 2, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 0)
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
    var testList = Array[Int]()
    for (x <- 0 to 80) {
      if (x % 9 == wantedColumn) {
        testList = testList :+ x%9
      }
    }
    assertEquals(sudokuTable.readColumn(wantedColumn).toSeq, testList.toSeq)
  }

  /**
  * 0 1 2 | 3 4 5 | 6 7 8
  * 0 1 2 | 3 4 5 | 6 7 8
  * 0 1 2 | 3 4 5 | 6 7 8
  * ----------------------
  * 0 1 2 | 3 4 5 | 6 7 8
  * 0 1 2 | 3 4 5 | 6 7 8
  * 0 1 2 | 3 4 5 | 6 7 8
  * ----------------------
  * 0 1 2 | 3 4 5 | 6 7 8
  * 0 1 2 | 3 4 5 | 6 7 8
  * 0 1 2 | 3 4 5 | 6 7 8
  * 
  * 0 | 1 | 2
  * 3 | 4 | 5
  * 6 | 7 | 8
  */
  test("readSquare") {
    assertEquals(sudokuTable.readSquare(0, 0).toSeq, Seq(0, 1, 2, 0, 1, 2, 0, 1, 2))
    assertEquals(sudokuTable.readSquare(3, 0).toSeq, Seq(3, 4, 5, 3, 4, 5, 3, 4, 5))
    assertEquals(sudokuTable.readSquare(6, 0).toSeq, Seq(6, 7, 8, 6, 7, 8, 6, 7, 8))
    assertEquals(sudokuTable.readSquare(0, 3).toSeq, Seq(0, 1, 2, 0, 1, 2, 0, 1, 2))
    assertEquals(sudokuTable.readSquare(3, 3).toSeq, Seq(3, 4, 5, 3, 4, 5, 3, 4, 5))
    assertEquals(sudokuTable.readSquare(6, 3).toSeq, Seq(6, 7, 8, 6, 7, 8, 6, 7, 8))
    assertEquals(sudokuTable.readSquare(0, 6).toSeq, Seq(0, 1, 2, 0, 1, 2, 0, 1, 2))
    assertEquals(sudokuTable.readSquare(3, 6).toSeq, Seq(3, 4, 5, 3, 4, 5, 3, 4, 5))
    assertEquals(sudokuTable.readSquare(6, 6).toSeq, Seq(6, 7, 8, 6, 7, 8, 6, 7, 8))
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
}
