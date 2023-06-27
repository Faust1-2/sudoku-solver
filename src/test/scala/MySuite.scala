import sudoku.Sudoku

class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }

  test("isValid") {

  }

  test("isSolved") {

  }

  test("readLine") {

  }

  test("readColumn") {
    val wantedColumn = 3
    var myList: List[Integer] = List()
    var testList: List[Integer] = List()
    for (x <- 0 to 80) {
      myList = myList :+ x
      if (x%9 == wantedColumn) {
        testList = testList :+ x
      }
    }
    val mySudoKu = Sudoku(myList)
    
    assertEquals(mySudoKu.readColumn(wantedColumn), testList)
  }

  test("readSquare") {

  }

  test("PrettyPrint") {
    var myList: List[Integer] = List()
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
