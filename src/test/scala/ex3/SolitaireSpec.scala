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
    ) shouldEqual "2  X  5  \nX  1  X  \n3  X  4  "
  }
  "render2" should "return a string representation of the board" in {
    render(
      solutions(1),
      3,
      3
    ) shouldEqual "2  X  3  \nX  1  X  \n5  X  4  "
  }
