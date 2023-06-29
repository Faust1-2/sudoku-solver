package sudoku

import zio._

object Main extends ZIOAppDefault {

  def run: ZIO[Any, Throwable, Unit] =

    var myList: Array[Array[Int]] = Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 9)
    )

    var myArray: Array[Array[Int]] = Array(
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

    val mySudoku = Sudoku(myArray)
    for {
      _ <- Console.print(mySudoku)
      // _ <- Console.print(mySudoku.readSquare(9).foreach(print))
      // _ <- Console.print(findSquare(lineIndex = 3, columnIndex = 0))
      _ <- Console.print(mySudoku.solve())
      // _ <- Console.print("Enter the path to the JSON file containing the Sudoku problem:")
      // path <- Console.readLine
      // _ <-  Console.printLine(s"You entered: $path")
      // Add your Sudoku solver logic here, utilizing ZIO and interacting with the ZIO Console
    } yield ()
}
