package sudoku

import scala.collection.mutable
import scala.util.boundary
import zio._
import zio.console._
import zio.nio.file._
import zio.json._
import zio.json.DecoderOps._


class Sudoku(grid: Array[Array[Int]]) {

  object Sudoku {
    implicit val decoder: JsonDecoder[Sudoku] = DeriveJsonDecoder.gen[Sudoku]
  }

  def parseJson(jsonStr: String): IO[String, Sudoku] = {
    ZIO.fromEither(jsonStr.fromJson[Sudoku]).mapError(_.getMessage)
  }

  def readFile(path: Path): ZIO[Blocking, String, String] = {
    ZIO.accessM[Blocking](_.get.blocking {
      FileChannel.open(path, StandardOpenOption.READ).map { channel =>
        val buffer = ByteBuffer.allocate(channel.size().toInt)
        channel.read(buffer)
        buffer.flip()
        new String(buffer.array(), "UTF-8")
      }.catchAllCause(cause => IO.fail(cause.prettyPrint))
    })
  }


  override def toString(): String = {
    val myString = mutable.StringBuilder()
    for (line <- 0 to 10) {
      for (value <- 0 to 8) {
        if (line == 0) myString.addAll(" ___")
        else if (line == 10) myString.addAll(" ‾‾‾")
        else myString.addAll("| %d ".format(grid(line - 1)(value)))
      }
      if (line != 0 && line != 10) myString.addAll("|\n")
      else myString.addAll("\n")
    }
    return myString.toString()
  }

  def isValid(): Boolean = {
    def hasDuplicates(list: Array[Int]): Boolean = {
      val filteredList = list.filter(_ != 0)
      filteredList.distinct.size != filteredList.size
    }

    def checkRows(): Boolean = {
      boundary:
        (0 until 9).foreach { row =>
          if (hasDuplicates(readLine(row))) {
            println(s"Duplicate value in row $row")
            boundary.break(false)
          }
        }
        true
    }

    def checkColumns(): Boolean = {
      boundary:
        (0 until 9).foreach { column =>
          if (hasDuplicates(readColumn(column))) {
            println(s"Duplicate value in column $column")
            boundary.break(false)
          }
        }
        true
    }

    def checkSquares(): Boolean = {
      boundary:
        List((0, 0), (0, 3), (0, 6), (3, 0), (3, 3), (3, 6), (6, 0), (6, 3), (6, 6)).foreach { (x, y) =>
          if (hasDuplicates(readSquare(x, y))) {
            println(s"Duplicate value in square $x , $y")
            boundary.break(false)
          }
        }
        true
    }

    checkRows() && checkColumns() && checkSquares()
  }

  def readColumn(column: Int): Array[Int] = {
    return grid.map((line) => line(column))
  }

  def readLine(line: Int): Array[Int] = grid(line)

  def readSquare(x: Int, y: Int): Array[Int] = {
    val boxLine = x / 3
    val boxColumn = y / 3

    val box = for {
      yB <- (boxColumn * 3) until (boxColumn * 3 + 3)
      xB <- (boxLine * 3) until (boxLine * 3 + 3)
    } yield grid(yB)(xB)

    return box.toArray
  }

  def isInputValid(x: Int, y: Int, value: Int): Boolean = {
    val isNotInLine = !readLine(y).contains(value)
    val isNotInColumn = !readColumn(x).contains(value)
    val isNotInBox = !readSquare(x, y).contains(value)

    return isNotInBox && isNotInColumn && isNotInLine
  }

  def solve(x: Int = 0, y: Int = 0): Boolean = {
    if (y == 9) {
      print(this)
      return true
    } else if (x == 9) return solve(0, y + 1)
    else if (grid(y)(x) != 0) return solve(x + 1, y)
    else
      boundary:
        for (value <- 1 to 9) {
          if (isInputValid(x, y, value)) {
            grid(y)(x) = value
            if (solve(x + 1, y)) boundary.break(true)
            grid(y)(x) = 0
          }
        }
    return false
  }
}
