package ex2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/** RobotWithBattery: a robot that has a battery level, which is decremented by
  * an amount passed as a parameter for each action it performs. It should not
  * be possible to perform an action if the battery level is 0.
  */
class RobotWithBatterySpec extends AnyFlatSpec with Matchers:

  "A RobotWithBattery" should "act and turn" in {
    val robot = new RobotWithBattery(SimpleRobot((0, 0), Direction.North), 10)

    robot.act()
    robot.position should be((0, 1))
    robot.direction should be(Direction.North)

    robot.turn(Direction.East)
    robot.direction should be(Direction.East)
  }

  it should "not act if battery is 0" in {
    val robot = new RobotWithBattery(SimpleRobot((0, 0), Direction.North), 0)

    robot.act()
    robot.position should be((0, 0))
  }

  it should "not turn if battery is 0" in {
    val robot = new RobotWithBattery(SimpleRobot((0, 0), Direction.North), 0)

    robot.turn(Direction.East)
    robot.direction should be(Direction.North)
  }
