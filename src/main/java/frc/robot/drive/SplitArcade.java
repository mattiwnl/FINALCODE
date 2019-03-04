package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SplitArcade extends Command {

    public SplitArcade() {
        requires(Robot.kDrive);
    }

    @Override
    protected void execute() {
        double leftX = -Robot.xbox.getRawAxis(0);
        double leftY = -Robot.xbox.getRawAxis(1);
        double rightX = -Robot.xbox.getRawAxis(4);
        double rightY = -Robot.xbox.getRawAxis(5);

        Robot.kDrive.driveLeft(leftY);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}