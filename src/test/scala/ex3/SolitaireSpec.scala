package ex3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SolitaireSpec extends AnyFlatSpec with Matchers:
  def render(solution: Seq[(Int, Int)], width: Int, height: Int): String =
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

  "render1" should "return a string representation of the board" in {
    render(
      Seq((0, 0), (2, 1)),
      3,
      3
    ) shouldEqual "1  X  2  \nX  X  X  \nX  3  X  "
  }
  "render2" should "return a string representation of the board" in {
    render(
      Seq((0, 0), (2, 1), (1, 0), (0, 1)),
      3,
      3
    ) shouldEqual "1  3  4  \n2  X  X  \nX  X  X  "
  }
  "render3" should "return a string representation of the board" in {
    render(
      Seq((0, 0), (2, 1), (1, 0), (0, 1), (2, 0), (1, 1)),
      3,
      3
    ) shouldEqual "1  3  4  \n2  5  6  \nX  X  X  "
  }
  "render4" should "return a string representation of the board" in {
    render(
      Seq((0, 0), (2, 1), (1, 0), (0, 1), (2, 0), (1, 1), (0, 2)),
      3,
      3
    ) shouldEqual "1  3  4  \n2  5  6  \n7  X  X  "
  }
  "render5" should "return a string representation of the board" in {
    render(
      Seq((0, 0), (2, 1), (1, 0), (0, 1), (2, 0), (1, 1), (0, 2), (2, 2)),
      3,
      3
    ) shouldEqual "1  3  4  \n2  5  6  \n7  8  X  "
  }
