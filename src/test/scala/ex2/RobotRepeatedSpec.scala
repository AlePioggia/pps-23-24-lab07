package ex2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/** RobotRepeated: a robot that repeats an action a given number of times
  * (passed as a parameter).
  */

class RobotRepeatedSpec extends AnyFlatSpec with Matchers:

  "A RobotRepeated" should "act and turn" in {
    val robot = new RobotRepeated(SimpleRobot((0, 0), Direction.North), 3)

    robot.act()
    robot.position should be((0, 3))
    robot.direction should be(Direction.North)
  }

  it should "repeat the north action" in {
    val robot = new RobotRepeated(SimpleRobot((0, 0), Direction.North), 3)

    robot.act()
    robot.position should be((0, 3))
  }

  it should "repeat the east action" in {
    val robot = new RobotRepeated(SimpleRobot((0, 0), Direction.East), 4)

    robot.act()
    robot.position should be((4, 0))
  }
