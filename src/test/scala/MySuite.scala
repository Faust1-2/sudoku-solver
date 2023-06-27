import sudoku.Sudoku

class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }

  test("isValid") {}

  test("isSolved") {}

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

}
