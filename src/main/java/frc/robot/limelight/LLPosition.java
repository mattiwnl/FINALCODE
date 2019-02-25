package frc.robot.limelight;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.Constants;

public class LLPosition extends Command {

    public LLPosition() {
        requires(Robot.kLimelight);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        boolean toggle1 = Robot.toggles.getRawButton(Constants.kToggle1Id);
        if(toggle1 == true) {
            Robot.kLimelight.LLServo(1);
        }else if(toggle1 == false) {
            Robot.kLimelight.LLServo(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}