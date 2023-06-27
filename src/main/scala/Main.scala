package sudoku

import zio._

object Main extends ZIOAppDefault {

  def run: ZIO[Any, Throwable, Unit] =

    var myList: List[Integer] = List()
    for (x <- 0 to 80) {
      myList = myList :+ x%9
    }

    val mySudoku = Sudoku(myList)
    mySudoku.prettyPrint()
    for {
      _ <- Console.print("Enter the path to the JSON file containing the Sudoku problem:")
      path <- Console.readLine
      _ <-  Console.printLine(s"You entered: $path")
      // Add your Sudoku solver logic here, utilizing ZIO and interacting with the ZIO Console
    } yield ()
}