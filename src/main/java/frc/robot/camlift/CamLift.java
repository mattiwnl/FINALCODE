package frc.robot.camlift;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.Constants;

public class CamLift extends Command {
    
    public CamLift() {
        requires(Robot.kCamLift);
    }

    @Override
    protected void execute() {
        boolean xboxMattButtonRB = Robot.xboxMatt.getRawButton(Constants.kXboxMattRightBumperId);
        boolean xboxMattButtonLB = Robot.xboxMatt.getRawButton(Constants.kXboxMattLeftBumperId);
        if(xboxMattButtonLB == true) {
            Robot.kCamLift.camLift(.5);
        }else if(xboxMattButtonRB == true) {
            Robot.kCamLift.camLift(-.5);
        }else{
            Robot.kCamLift.camLift(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}