package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Robot;

public class NavxDriveStraight extends Command {

    public NavxDriveStraight() {
        requires(Robot.kDrive);
        requires(Robot.kNavx);
    }
    
    @Override
    protected void execute() {
        double angle = Robot.kNavx.gyro.getAngle();
        SmartDashboard.putNumber("angle", angle);
        boolean xboxA = Robot.xbox.getRawButton(Constants.kXboxButtonAId);
        if(xboxA == true) {
            if(angle < 5 && angle > -5){
                Robot.kDrive.driveLeft(.4);
                Robot.kDrive.driveRight(.3);
            }else if(angle < 9 && angle > 5){
                Robot.kDrive.driveLeft(.3);
                Robot.kDrive.driveRight(.3);
            }else if(angle > -9 && angle < -5){
                Robot.kDrive.driveLeft(.3);
                Robot.kDrive.driveRight(.3);
            }else if(angle > 9){
                Robot.kDrive.driveLeft(0);
                Robot.kDrive.driveRight(.4);
            }else if(angle < -9){
                Robot.kDrive.driveLeft(.4);
                Robot.kDrive.driveRight(0);
            }
        }else if (xboxA == false){
            Robot.kDrive.driveLeft(0);
            Robot.kDrive.driveRight(0); 
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
