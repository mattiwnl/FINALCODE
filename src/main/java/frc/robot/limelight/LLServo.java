package frc.robot.limelight;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.Constants;

public class LLServo extends Command {

    public LLServo() {
        requires(Robot.kLimelight);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        boolean xboxStart = Robot.xbox.getRawButton(Constants.kXboxButtonStartId);
        boolean xboxSelect = Robot.xbox.getRawButton(Constants.kXboxButtonSelectId);
        if(xboxStart == true) {
            Robot.kLimelight.LLservo(1);
        }else if(xboxStart == false) {
            Robot.kLimelight.LLservo(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}