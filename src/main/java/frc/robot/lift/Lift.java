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
        boolean xboxButtonRB = Robot.xbox.getRawButton(Constants.kXboxRightBumperId);
        boolean xboxButtonLB = Robot.xbox.getRawButton(Constants.kXboxLeftBumperId);
        if(xboxButtonLB == true) {
            Robot.kLift.lift(.5);
        }else if(xboxButtonRB == true) {
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