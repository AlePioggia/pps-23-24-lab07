package ex3

object Solitaire extends App:

  type Cell = (Int, Int)
  type Solution = Seq[Cell]

  def render(solution: Seq[Cell], width: Int, height: Int): String =
    val reversed = solution.reverse
    val rows =
      for
        y <- 0 until height
        row = for
          x <- 0 until width
          number = reversed.indexOf((x, y)) + 1
        yield if number > 0 then "%-2d ".format(number) else "X  "
      yield row.mkString
    rows.mkString("\n")

  def placeMarks(width: Int, height: Int): List[Seq[Cell]] = ???

  // println(render(solution = Seq((0, 0), (2, 1)), width = 3, height = 3))
