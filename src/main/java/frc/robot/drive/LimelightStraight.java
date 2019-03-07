package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class LimelightStraight extends Command {

    public LimelightStraight() {
        requires(Robot.kDrive);
        requires(Robot.kLimelight);
    }
    
    @Override
    protected void execute() {
    double llX = Robot.x;
    double llArea = Robot.area;
        if(llArea < 20){
            Robot.kDrive.driveLeft(.3);
            Robot.kDrive.driveRight(.25);
        }else if(llArea >= 20){
            Robot.kDrive.driveLeft(0);
            Robot.kDrive.driveRight(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}