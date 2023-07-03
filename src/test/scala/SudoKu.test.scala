import sudoku.Sudoku
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class SudokuTest extends munit.FunSuite {

  var sudokuMatrix = Array[Array[Int]]()

  for(x <- 0 to 8) {
    var sudokuLine = Array[Int]()
    for(y <- 0 to 8) {
      sudokuLine = sudokuLine :+ y
    }
    sudokuMatrix = sudokuMatrix :+ sudokuLine
  }

  val sudokuTable = Sudoku(sudokuMatrix)

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

  test("solve") {
    val sudoku1 = Sudoku(Array(
      Array(0, 7, 0, 5, 8, 3, 0, 2, 0),
      Array(0, 5, 9, 2, 0, 0, 3, 0, 0),
      Array(3, 4, 0, 0, 0, 6, 5, 0, 7),
      Array(7, 9, 5, 0, 0, 0, 6, 3, 2),
      Array(0, 0, 3, 6, 9, 7, 1, 0, 0),
      Array(6, 8, 0, 0, 0, 2, 7, 0, 0),
      Array(9, 1, 4, 8, 3, 5, 0, 7, 6),
      Array(0, 3, 0, 7, 0, 1, 4, 9, 5),
      Array(5, 6, 7, 4, 2, 9, 0, 1, 3)
    ))
    val sudoku2 = Sudoku(Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 9)
    ))

    val solution1 = Seq(
      Seq(1, 7, 6, 5, 8, 3, 9, 2, 4),
      Seq(8, 5, 9, 2, 7, 4, 3, 6, 1), 
      Seq(3, 4, 2, 9, 1, 6, 5, 8, 7), 
      Seq(7, 9, 5, 1, 4, 8, 6, 3, 2), 
      Seq(4, 2, 3, 6, 9, 7, 1, 5, 8), 
      Seq(6, 8, 1, 3, 5, 2, 7, 4, 9), 
      Seq(9, 1, 4, 8, 3, 5, 2, 7, 6), 
      Seq(2, 3, 8, 7, 6, 1, 4, 9, 5), 
      Seq(5, 6, 7, 4, 2, 9, 8, 1, 3)
    )
    val solution2 = Seq(
      Seq(5, 3, 4, 6, 7, 8, 9, 1, 2), 
      Seq(6, 7, 2, 1, 9, 5, 3, 4, 8),
      Seq(1, 9, 8, 3, 4, 2, 5, 6, 7),
      Seq(8, 5, 9, 7, 6, 1, 4, 2, 3), 
      Seq(4, 2, 6, 8, 5, 3, 7, 9, 1), 
      Seq(7, 1, 3, 9, 2, 4, 8, 5, 6), 
      Seq(9, 6, 1, 5, 3, 7, 2, 8, 4), 
      Seq(2, 8, 7, 4, 1, 9, 6, 3, 5), 
      Seq(3, 4, 5, 2, 8, 6, 1, 7, 9) 
    )

    sudoku1.solve()
    sudoku2.solve()
    
    val result1: Seq[Seq[Int]] = for {
      line <- sudoku1.getGrid()
    } yield line.toSeq

    val result2: Seq[Seq[Int]] = for {
      line <- sudoku2.getGrid()
    } yield line.toSeq

    assert(solution1 == result1)
    assert(solution2 == result2)
  }

  test("toString") {
    assertNoDiff(
      sudokuTable.toString(),
      """ ___ ___ ___ ___ ___ ___ ___ ___ ___
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
 ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾"""
    )
  }
}
