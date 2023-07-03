import sudoku._
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ParseTest extends munit.FunSuite {
  test("validateFormat") {
    val validGrid = Array(
      Array(0, 7, 0, 5, 8, 3, 0, 2, 0),
      Array(0, 5, 9, 2, 0, 0, 3, 0, 0),
      Array(3, 4, 0, 0, 0, 6, 5, 0, 7),
      Array(7, 9, 5, 0, 0, 0, 6, 3, 2),
      Array(0, 0, 3, 6, 9, 7, 1, 0, 0),
      Array(6, 8, 0, 0, 0, 2, 7, 0, 0),
      Array(9, 1, 4, 8, 3, 5, 0, 7, 6),
      Array(0, 3, 0, 7, 0, 1, 4, 9, 5),
      Array(5, 6, 7, 4, 2, 9, 0, 1, 3)
    )

    val invalidValues1 = Array(
      Array(-1, 7, 0, 5, 8, 3, 0, 2, 0),
      Array(0, 5, 9, 2, 0, 0, 3, 0, 0),
      Array(3, 4, 0, 0, 0, 6, 5, 0, 7),
      Array(7, 9, 5, 0, 0, 0, 6, 3, 2),
      Array(0, 0, 3, 6, 9, 7, 1, 0, 0),
      Array(6, 8, 0, 0, 0, 2, 7, 0, 0),
      Array(9, 1, 4, 8, 3, 5, 0, 7, 6),
      Array(0, 3, 0, 7, 0, 1, 4, 9, 5),
      Array(5, 6, 7, 4, 2, 9, 0, 1, 3)
    )

    val invalidValues2 = Array(
      Array(0, 7, 0, 5, 8, 3, 0, 2, 0),
      Array(0, 5, 9, 2, 0, 0, 3, 0, 0),
      Array(3, 4, 0, 10, 0, 6, 5, 0, 7),
      Array(7, 9, 5, 0, 0, 0, 6, 3, 2),
      Array(0, 0, 3, 6, 9, 7, 1, 0, 0),
      Array(6, 8, 0, 0, 0, 2, 7, 0, 0),
      Array(9, 1, 4, 8, 3, 5, 0, 7, 6),
      Array(0, 3, 0, 7, 0, 1, 4, 9, 5),
      Array(5, 6, 7, 4, 2, 9, 0, 1, 3)
    )

    val invalidNumberOfLine1 = Array(
      Array(0, 7, 0, 5, 8, 3, 0, 2, 0),
      Array(0, 5, 9, 2, 0, 0, 3, 0, 0),
    )
    
    val invalidNumberOfLine2 = Array(
      Array(0, 7, 0, 5, 8, 3, 0, 2, 0),
      Array(0, 5, 9, 2, 0, 0, 3, 0, 0),
      Array(3, 4, 0, 0, 0, 6, 5, 0, 7),
      Array(7, 9, 5, 0, 0, 0, 6, 3, 2),
      Array(0, 0, 3, 6, 9, 7, 1, 0, 0),
      Array(6, 8, 0, 0, 0, 2, 7, 0, 0),
      Array(9, 1, 4, 8, 3, 5, 0, 7, 6),
      Array(0, 3, 0, 7, 0, 1, 4, 9, 5),
      Array(0, 3, 0, 7, 0, 1, 4, 9, 5),
      Array(5, 6, 7, 4, 2, 9, 0, 1, 3)
    )

    val invalidLineSize1 = Array(
      Array(0, 7, 0, 5, 8, 3, 0, 2),
      Array(0, 5, 9, 2, 0, 0, 3, 0),
      Array(3, 4, 0, 0, 0, 6, 5, 0),
      Array(7, 9, 5, 0, 0, 0, 6, 3),
      Array(0, 0, 3, 6, 9, 7, 1, 0),
      Array(6, 8, 0, 0, 0, 2, 7, 0),
      Array(9, 1, 4, 8, 3, 5, 0, 7),
      Array(0, 3, 0, 7, 0, 1, 4, 9),
      Array(5, 6, 7, 4, 2, 9, 0, 1)
    )

    val invalidLineSize2 = Array(
      Array(0, 7, 0, 5, 8, 3, 0, 2, 0),
      Array(0, 5, 9, 2, 0, 0, 3, 0),
      Array(3, 4, 0, 0, 0, 6, 5, 0, 7),
      Array(7, 9, 5, 0, 0, 0, 6, 3, 2),
      Array(0, 0, 3, 6, 9, 7, 1, 0, 0),
      Array(6, 8, 0, 0, 0, 2, 7, 0, 0),
      Array(9, 1, 4, 8, 3, 5, 0, 7, 6),
      Array(0, 3, 0, 7, 0, 1, 4, 9, 5),
      Array(5, 6, 7, 4, 2, 9, 0, 1, 3)
    )

    assertEquals(validateFormat(validGrid), true)
    assertEquals(validateFormat(invalidValues1), false)
    assertEquals(validateFormat(invalidValues2), false)
    assertEquals(validateFormat(invalidNumberOfLine1), false)
    assertEquals(validateFormat(invalidNumberOfLine2), false)
    assertEquals(validateFormat(invalidLineSize1), false)
    assertEquals(validateFormat(invalidLineSize2), false)
  }
}
