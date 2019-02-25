package frc.robot.drive;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.Robot;

public class AutoDrive extends TimedCommand {
    
    public static double goal = 8;
    public static double kP = 0.125;

    public AutoDrive() {
        super(.75);
        requires(Robot.kDrive);
    }
    
    @Override
    protected void execute() {
        double left = Robot.kDrive.getLeft();
        double right = Robot.kDrive.getRight();

        double leftError = goal - left;
        double rightError = goal - right;

        Robot.kDrive.driveLeft(leftError * kP);
        Robot.kDrive.driveRight(rightError * kP);
    }
}
