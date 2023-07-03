package sudoku

import java.io.FileNotFoundException
import scala.io.Source
import zio._
import zio.json._
import scala.util.boundary

type Grid = Array[Array[Int]]

def parseFile(path: String): ZIO[Any, Throwable, Grid] = {
  val jsonString = Source.fromFile(path).mkString
  val maybeSudoku = jsonString.fromJson[Grid]

  maybeSudoku.match
    case Right(value) => ZIO.from(value)
    case Left(value) => throw FileNotFoundException()
}

def validateFormat(grid: Grid): Boolean = ???