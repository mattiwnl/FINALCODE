package frc.robot.camwheel;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.Constants;

public class CamWheel extends Command {
    
    public CamWheel() {
        requires(Robot.kCamWheel);
    }

    @Override
    protected void execute() {
        double xboxMattLeftTrigger = Robot.xboxMatt.getRawAxis(Constants.kXboxMattLeftTriggerId);
        double xboxMattRightTrigger = Robot.xboxMatt.getRawAxis(Constants.kXboxMattRightTriggerId);
        if(xboxMattRightTrigger > .1) {
            Robot.kCamWheel.camWheelLeft(1);
            Robot.kCamWheel.camWheelRight(1);
        }else if(xboxMattLeftTrigger > .1) {
            Robot.kCamWheel.camWheelLeft(-1);
            Robot.kCamWheel.camWheelRight(-1);
        }else{
            Robot.kCamWheel.camWheelLeft(0);
            Robot.kCamWheel.camWheelRight(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}