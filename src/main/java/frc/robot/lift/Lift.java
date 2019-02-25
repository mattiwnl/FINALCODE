package frc.robot.lift;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.Constants;

public class Lift extends Command {
    
    public Lift() {
        requires(Robot.kLift);
    }

    @Override
    protected void execute() {
        boolean xboxButtonX = Robot.xbox.getRawButton(Constants.kXboxButtonXId);
        boolean xboxButtonY = Robot.xbox.getRawButton(Constants.kXboxButtonYId);
        if(xboxButtonY == true) {
            Robot.kLift.lift(.5);
        }else if(xboxButtonX == true) {
            Robot.kLift.lift(-.5);
        }else{
            Robot.kLift.lift(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}