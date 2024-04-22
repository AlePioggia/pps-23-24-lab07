package ex3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import ex3.Solitaire.*

class SolitaireSpec extends AnyFlatSpec with Matchers:
  val solutions = placeMarks(3, 3)
  "render1" should "return a string representation of the board" in {
    render(
      solutions(0),
      3,
      3
    ) shouldEqual "1  X  2  \nX  X  X  \nX  3  X  "
  }
  "render2" should "return a string representation of the board" in {
    render(
      solutions(1),
      3,
      3
    ) shouldEqual "1  3  4  \n2  X  X  \nX  X  X  "
  }
  "render3" should "return a string representation of the board" in {
    render(
      solutions(2),
      3,
      3
    ) shouldEqual "1  3  4  \n2  5  6  \nX  X  X  "
  }
  "render4" should "return a string representation of the board" in {
    render(
      solutions(3),
      3,
      3
    ) shouldEqual "1  3  4  \n2  5  6  \n7  X  X  "
  }
  "render5" should "return a string representation of the board" in {
    render(
      solutions(4),
      3,
      3
    ) shouldEqual "1  3  4  \n2  5  6  \n7  8  X  "
  }
