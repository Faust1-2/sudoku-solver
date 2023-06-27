import sudoku.Sudoku

class MySuite extends munit.FunSuite {

  val sudoKu = Sudoku(List.range(0, 81).map(x => x%9))

  test("isValid") {}

  test("isSolved") {}

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
    var myList: List[Int] = List()
    for (x <- 0 to 80) {
      myList = myList :+ x%9
    }
    val mySudoKu = Sudoku(myList)

    assertEquals(mySudoKu.findSquare(0, 0), 0)
    assertEquals(mySudoKu.findSquare(4, 2), 1)
    assertEquals(mySudoKu.findSquare(2, 4), 3)
    assertEquals(mySudoKu.findSquare(7, 5), 5)
    assertEquals(mySudoKu.findSquare(5, 8), 7)
  }

}
