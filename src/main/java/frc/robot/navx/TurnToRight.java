package frc.robot.navx;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnToRight extends Command {

    double pitch = Robot.kNavx.kPitch;
    double yaw = Robot.kNavx.kYaw;
    double angle = Robot.kNavx.kAngle;

    boolean done = false;

    public TurnToRight() {
        requires(Robot.kNavx);
    }

    @Override
    protected void initialize() {
        done = false;
    }
    
    @Override
    protected void execute() {
        if(angle > 90.5 && angle <= 180.5) {
            Robot.kDrive.driveLeft(-.25);
            Robot.kDrive.driveRight(.25); 
        }else if(angle < 89.5 && angle >= -180.5) {
            Robot.kDrive.driveLeft(.25);
            Robot.kDrive.driveRight(-.25); 
        }else if(angle < 90.5 && angle > 89.5) {
            Robot.kDrive.driveLeft(0);
            Robot.kDrive.driveRight(0); 
            done = false;
        }
    }

    @Override
    protected boolean isFinished() {
        return done;
    }
}