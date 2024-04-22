package ex3

import javax.swing.text.Position

object Solitaire extends App:
  import ImplementationHelpers.*

  type Solution = List[Position]
  type Solutions = List[Solution]
  case class Position(x: Int, y: Int)

  def placeMarks(width: Int, height: Int): Solutions =
    val initialPosition = Position(width / 2, height / 2)
    val startingValue = getStartingValue(width, height)
    computeSolution(width, height)(initialPosition)(startingValue)

  def renderSolution(sol: Solution, w: Int, h: Int): String =
    render(sol, w, h)

  private object ImplementationHelpers:
    def computeSolution(w: Int, h: Int)(p: Position)(acc: Int): Solutions =
      acc match
        case 1 => List(List(p))
        case _ =>
          for
            sol <- computeSolution(w, h)(p)(
              acc - 1
            )
            x <- 0 until w
            y <- 0 until h
            nextPos = Position(x, y)
            if isValidMove(sol, sol.last, nextPos)
          yield sol :+ nextPos

    def isValidMove(sol: Solution, pos: Position, next: Position): Boolean =
      def canMove(): Boolean =
        val dx = (sol.last.x - pos.x).abs
        val dy = (sol.last.y - pos.y).abs
        (dx == 2 && dy == 0) || (dx == 0 && dy == 2) || (dx == 1 && dy == 1)
      canMove() && !sol.contains(next)

    def render(sol: Solution, w: Int, h: Int): String =
      val reversed = sol
      val rows =
        for
          y <- 0 until h
          row = for
            x <- 0 until w
            number = reversed.indexOf(Position(x, y)) + 1
          yield if number > 0 then "%-2d ".format(number) else "X  "
        yield row.mkString
      rows.mkString("\n")

    def getStartingValue(width: Int, height: Int): Int =
      def Middle: Int = (width * height) / 2
      width * height - Middle
