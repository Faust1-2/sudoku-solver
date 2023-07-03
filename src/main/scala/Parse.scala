package sudoku

import java.io.FileNotFoundException
import scala.io.Source
import zio._
import zio.json._

def parseFile(path: String): ZIO[Any, Throwable, SudokuCase] = {
  val jsonString = Source.fromFile(path).mkString
  val maybeSudoku = jsonString.fromJson[SudokuCase]

  maybeSudoku.match
    case Right(value) => ZIO.from(value)
    case Left(value) => throw FileNotFoundException()
}

case class SudokuCase(grid: Array[Array[Int]])

object SudokuCase {
  implicit val decoder: JsonDecoder[SudokuCase] = DeriveJsonDecoder.gen[SudokuCase]
}