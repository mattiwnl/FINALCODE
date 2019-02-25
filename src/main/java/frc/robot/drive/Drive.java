package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Drive extends Command {

    public Drive() {
        requires(Robot.kDrive);
    }

    @Override
    protected void execute() {
        double left = -Robot.xbox.getRawAxis(1);
        double right = -Robot.xbox.getRawAxis(5);
            if(left > .1 || left < -.1) {
                Robot.kDrive.driveLeft(left);
            }else{
                Robot.kDrive.driveLeft(0);
            }
            if(right > .1 || right < -.1) {
                Robot.kDrive.driveRight(right);
            }else{
                Robot.kDrive.driveRight(0);
            }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}