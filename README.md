# Class Exam Instruction: Sudoku Solver in Scala

## Topic

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

## Initialisation of the project



## Accepted JSON format

## Expectations

1. Data Structure: Design an appropriate data structure to represent the Sudoku problem and solution. Ensure the data structure supports immutability and functional programming principles where possible. You have adopt an iterative approach with solving the problem first and then improving the data structure and/or the other application features.

1. ZIO Console Interaction: The solver should interact with the ZIO Console by requesting the user to provide a JSON file path containing a Sudoku problem. Upon receiving the path, the solver should attempt to solve the Sudoku puzzle and display the solution, if it exists.

1. Error Handling: Implement proper error handling mechanisms using ZIO's error handling capabilities. Handle scenarios such as invalid file paths, malformed JSON files, unsolvable Sudoku puzzles, etc. Provide informative error messages to the user.

1. Git Repository: Create a Git repository to manage your Sudoku solver project. Commit your code regularly and maintain a well-structured project organization.

1. Documentation Quality: Provide clear and concise documentation explaining the purpose, functionality, and usage of your Sudoku solver. Include instructions on how to run the solver and any additional setup required. Document any external libraries used and their significance in the project.

1. Recursive Approach: Implement the Sudoku solver using a recursive approach. Utilize the functional programming concepts available in Scala to write clean and readable recursive code.

1. Testing: Write appropriate tests to validate the correctness of your Sudoku solver implementation. Include test cases that cover various scenarios, such as empty grids, partially filled grids, invalid Sudoku puzzles, and solvable puzzles.

1. Functional Properties: Whenever possible, leverage the functional programming principles such as immutability, pure functions, and referential transparency. Aim to write code that is easy to reason about, test, and maintain.

## Grading

Your solution will be graded based on the following criteria:

1. Correctness and functionality of the Sudoku solver implementation.

1. Effective usage of ZIO, including error handling and ZIO Console interaction.

1. Quality of code organization, adherence to functional programming principles, and use of recursion.

1. Testing completeness and effectiveness, covering various scenarios.

1. Quality and clarity of documentation, including the README file.

1. Collaboration within the group and active participation of each member.

1. Timely submission of the project by the specified due date.