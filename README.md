# Sudoku Solver in Scala

## Presentation

This application is a Sudoku solver in Scala 3 using [ZIO](https://zio.dev/overview/getting-started), a purely functional, type-safe, composable library for asynchronous, concurrent programming in Scala. 

## Description of the game

Sudoku is a popular logic-based puzzle game played on a 9x9 grid. The grid is divided into 9 rows, 9 columns, and 9 3x3 sub-grids. The objective is to fill the grid with digits from 1 to 9 such that each row, each column, and each sub-grid contains all the digits from 1 to 9 without any repetition. A partially filled Sudoku grid is given as input, and the solver should determine a solution if one exists.

### Unresolved Sudoku Grid

| <!-- -->| <!-- --> | <!-- --> | <!-- --> | <!-- --> | <!-- --> |<!-- -->| <!-- --> | <!-- --> |
|---|---|---|---|---|---|---|---|---|
| 5 | 3 |   |   | 7 |   |   |   |   |
| 6 |   |   | 1 | 9 | 5 |   |   |   |
|   | 9 | 8 |   |   |   |   | 6 |   |
| 8 |   |   |   | 6 |   |   |   | 3 |
| 4 |   |   | 8 |   | 3 |   |   | 1 |
| 7 |   |   |   | 2 |   |   |   | 6 |
|   | 6 |   |   |   |   | 2 | 8 |   |
|   |   |   | 4 | 1 | 9 |   |   | 5 |
|   |   |   |   | 8 |   |   | 7 | 9 |

### Solution
| <!-- -->| <!-- --> | <!-- --> | <!-- --> | <!-- --> | <!-- --> |<!-- -->| <!-- --> | <!-- --> |
|---|---|---|---|---|---|---|---|---|
| 5 | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 |
| 6 | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 |
| 1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 |
| 8 | 5 | 9 | 7 | 6 | 1 | 4 | 2 | 3 |
| 4 | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 |
| 7 | 1 | 3 | 9 | 2 | 4 | 8 | 5 | 6 |
| 9 | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 |
| 2 | 8 | 7 | 4 | 1 | 9 | 6 | 3 | 5 |
| 3 | 4 | 5 | 2 | 8 | 6 | 1 | 7 | 9 |

## Initialisation and running of the project

In order to run the project, you will need to run specific commands in the following order :

- This command will make you connect to the sbt build server. It will load all the dependencies stored in the `build.sbt` file.
  ```
  sbt
  ```

- You can now run the project with :
  ```
  run
  ```

- In any case, if you edit the build.sbt file, please enter into the sbt server and run :
  ```
  reload
  ```
  Or run directly :
  ```
  sbt reload
  ```

## Accepted JSON format

The sudoku grids are stored in JSON files, that are read by the application on run time. Those files need to follow the defined format that you can find here :

```json
[
  [v, v, v, v, v, v, v, v, v],
  [v, v, v, v, v, v, v, v, v],
  [v, v, v, v, v, v, v, v, v],
  [v, v, v, v, v, v, v, v, v],
  [v, v, v, v, v, v, v, v, v],
  [v, v, v, v, v, v, v, v, v],
  [v, v, v, v, v, v, v, v, v],
  [v, v, v, v, v, v, v, v, v],
  [v, v, v, v, v, v, v, v, v],
]

```

With each **`v`** representing a value that you can set in the range **0 to 9**. With **0 representing the absence of value** and the values from **1 to 9 being real values of our sudoku grid**.

⚠️ If you do not follow this format, the program will not run.⚠️

The program will ask you to enter the path of the JSON sudoku. We recommend you to create a folder to store all your JSON sudoku at the same place. 

## Algorithm explanations

### Before solving

The program will make sure that the sudoku grid is valid. According to the [sudoku rules](https://www.sudokuonline.io/tips/sudoku-rules), one value can only appears once in a line, column and 3x3 sub-grid.

Our application will check that this rule is respected before trying to solve it. In case you have a duplicate value, the application will give you the line, column, or sub-grid where the duplicate is. For more informations about lines, columns and sub-grid indexes, please refer to the ***More information*** section.

### Solving algorithm

Our program use a "back-tracking" algorithm to solve the sudoku. It is a recursive algorithm that simply tries every possibility for each case of the sudoku. For more information about how it works, we invite you to refer to the following link: [Sudoku BackTracking](https://en.wikipedia.org/wiki/Sudoku_solving_algorithms#Backtracking)


## More information

In case you are lost at which column, line or sub-grid is concerned by an error, please refer to this part.

### Line and column indexes

|   i   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|-------|---|---|---|---|---|---|---|---|---|
| **0** | v | v | v | v | v | v | v | v | v |
| **1** | v | v | v | v | v | v | v | v | v |
| **2** | v | v | v | v | v | v | v | v | v |
| **3** | v | v | v | v | v | v | v | v | v |
| **4** | v | v | v | v | v | v | v | v | v |
| **5** | v | v | v | v | v | v | v | v | v |
| **6** | v | v | v | v | v | v | v | v | v |
| **7** | v | v | v | v | v | v | v | v | v |
| **8** | v | v | v | v | v | v | v | v | v |

### Sub-grid indexes

| <!--  --> | <!--  --> | <!--  --> |
| :-------: | :-------: | :-------: |
|     0     |     1     |     2     |
|     3     |     4     |     5     |
|     6     |     7     |     8     |