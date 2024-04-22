package ex2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/** RobotCanFail: a robot that can fail with a given probability (passed as a
  * parameter) when performing an action. If it fails, it should not perform the
  * action
  */

class RobotCanFailSpec extends AnyFlatSpec with Matchers:

  it should "not act if probability is 1" in {
    val robot = new RobotCanFail(SimpleRobot((0, 0), Direction.North), 1)

    robot.act()
    robot.position should be((0, 0))
  }

  it should "not turn if probability is 1" in {
    val robot = new RobotCanFail(SimpleRobot((0, 0), Direction.North), 1)

    robot.turn(Direction.East)
    robot.direction should be(Direction.North)
  }
