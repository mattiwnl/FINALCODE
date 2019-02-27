package frc.robot.navx;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class TurnToBack extends Command {

    boolean done = false;

    public TurnToBack() {
        requires(Robot.kNavx);
    }

    @Override
    protected void initialize() {
        done = false;
    }
    
    @Override
    protected void execute() {
        double angle = Robot.kNavx.gyro.getAngle();
        if(angle < 179 && angle > -1) {
            Robot.kDrive.driveLeft(.25);
            Robot.kDrive.driveRight(-.25); 
        }else if(angle > -179 && angle < 1) {
            Robot.kDrive.driveLeft(-.25);
            Robot.kDrive.driveRight(.25); 
        }else if(angle < -179 && angle > 179) {
            Robot.kDrive.driveLeft(0);
            Robot.kDrive.driveRight(0); 
            done = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return done;
    }
}