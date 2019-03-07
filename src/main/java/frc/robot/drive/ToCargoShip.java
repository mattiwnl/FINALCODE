package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class ToCargoShip extends Command {

    boolean done = false;

    public ToCargoShip() {
        requires(Robot.kDrive);
    }
    
    @Override
    protected void execute() {
        double llArea = Robot.area; // area value from the limelight camera
        if(llArea < 45) {
            Robot.kDrive.driveLeft(.25);
            Robot.kDrive.driveRight(.25);
        }else if(llArea >= 45) {
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