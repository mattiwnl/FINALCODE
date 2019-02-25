package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class BackOffCargoShip extends Command {

    public static double llArea = Robot.kLimelight.area;

    boolean done = false;

    public BackOffCargoShip() {
        requires(Robot.kDrive);
    }
    
    @Override
    protected void execute() {
        if(llArea > 15){
            Robot.kDrive.driveLeft(-.25);
            Robot.kDrive.driveRight(-.25);
        }else if(llArea <= 15){
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
