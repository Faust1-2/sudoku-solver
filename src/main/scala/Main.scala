package sudoku

import zio._

object Main extends ZIOAppDefault {

  def run: ZIO[Any, Throwable, Unit] =
    for {
      _ <- Console.print("Enter the path to the JSON file containing the Sudoku problem:")
      path <- Console.readLine
      grid <- parseFile(path)
        .catchAll ({ error =>
          for {
            _ <- ZIO.logErrorCause("file error", Cause.fail(error))
          } yield ()
          ZIO.die(error)
        })
      sudoku <- ZIO.from(Sudoku(grid = grid))
      _ <- Console.printLine(s"Successfully parsed Sudoku grid:\n$sudoku")
      _ <- ZIO.from(sudoku.solve())
      _ <- Console.printLine(sudoku)
    } yield ()
}
