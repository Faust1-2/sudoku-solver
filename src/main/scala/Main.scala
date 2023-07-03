package sudoku

import zio._

object Main extends ZIOAppDefault {

  def run: ZIO[Any, Throwable, Unit] =
    for {
      _ <- Console.print("Enter the path to the JSON file containing the Sudoku problem:")
      path <- Console.readLine
      grid <- parseFile(path)
        .catchAll { error =>
          for {
            _ <- ZIO.logError("file error")
            defaultGrid <- ZIO.from(
              Array(
                Array(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Array(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Array(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Array(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Array(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Array(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Array(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Array(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
              )
            )
          } yield defaultGrid
        }
      sudoku <- ZIO.from(Sudoku(grid = grid))
      _ <- Console.printLine(s"Successfully parsed Sudoku grid:\n$sudoku")
      _ <- ZIO.from(sudoku.solve())
      _ <- Console.printLine(sudoku)
    } yield ()
}
