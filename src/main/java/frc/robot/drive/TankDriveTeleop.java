package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class TankDriveTeleop extends Command {

    public TankDriveTeleop() {
        requires(Robot.kDrive);
    }

    @Override
    protected void execute() {
        double xboxLeft = -Robot.xbox.getRawAxis(1);
        double xboxRight = -Robot.xbox.getRawAxis(5);

        boolean xboxMattStart = Robot.xboxMatt.getRawButton(Constants.kXboxMattButtonStartId);
        boolean xboxMattSelect = Robot.xboxMatt.getRawButton(Constants.kXboxMattButtonSelectId);

        if(xboxMattStart == true){
            Robot.driveCounter = 0;
        }else if(xboxMattSelect == true){
            Robot.driveCounter = 1;
        }
        if(Robot.driveCounter == 0){
            Robot.kDrive.driveLeft(xboxLeft);
            Robot.kDrive.driveRight(xboxRight);
        }else if(Robot.driveCounter == 1){
            Robot.kDrive.driveLeft(xboxRight * -1);
            Robot.kDrive.driveRight(xboxLeft * -1);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}