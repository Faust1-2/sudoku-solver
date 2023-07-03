package sudoku

import java.io.FileNotFoundException
import scala.io.Source
import zio._
import zio.json._
import scala.util.boundary
import java.io.InvalidObjectException

type Grid = Array[Array[Int]]

def parseFile(path: String): ZIO[Any, Throwable, Grid] = {
  val jsonString = Source.fromFile(path).mkString
  val maybeSudoku = jsonString.fromJson[Grid]
  
  maybeSudoku.match
    case Right(value) => {
      if (validateFormat(value)) ZIO.from(value)
      else throw InvalidObjectException(value.toString())
    }
    case Left(value) => throw FileNotFoundException()
}

def validateFormat(grid: Grid): Boolean = {
  val acceptedValues = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  boundary:
    if(grid.length == 9) {
      for (line <- grid) {
        if(line.length != 9) boundary.break(false)
        for (value <- line) {
          if(!acceptedValues.contains(value)) {
            boundary.break(false)
          }
        }
      }
      boundary.break(true)
    }
    else {
      boundary.break(false)
    }
}