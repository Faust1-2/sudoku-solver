package sudoku

import zio._

import sudoku

object Main extends ZIOAppDefault {

  def run: ZIO[Any, Throwable, Unit] =

    var myList: Array[Int] = Array(
      5,3,0,0,7,0,0,0,0,
      6,0,0,1,9,5,0,0,0,
      0,9,8,0,0,0,0,6,0,
      8,0,0,0,6,0,0,0,3,
      4,0,0,8,0,3,0,0,1,
      7,0,0,0,2,0,0,0,6,
      0,6,0,0,0,0,2,8,0,
      0,0,0,4,1,9,0,0,5,
      0,0,0,0,8,0,0,7,9
    )

    var myArray: Array[Int] = Array(
      0,7,0,5,8,3,0,2,0,
      0,5,9,2,0,0,3,0,0,
      3,4,0,0,0,6,5,0,7,
      7,9,5,0,0,0,6,3,2,
      0,0,3,6,9,7,1,0,0,
      6,8,0,0,0,2,7,0,0,
      9,1,4,8,3,5,0,7,6,
      0,3,0,7,0,1,4,9,5,
      5,6,7,4,2,9,0,1,3
    )

    val mySudoku = Sudoku(myList)
    for {
      _ <- Console.print(mySudoku)
      // _ <- Console.print(mySudoku.readSquare(9).foreach(print))
      // _ <- Console.print(findSquare(lineIndex = 3, columnIndex = 0))
      // _ <- Console.print(solve(mySudoku, 0, 0))
      // _ <- Console.print("Enter the path to the JSON file containing the Sudoku problem:")
      // path <- Console.readLine
      // _ <-  Console.printLine(s"You entered: $path")
      // Add your Sudoku solver logic here, utilizing ZIO and interacting with the ZIO Console
    } yield ()
}