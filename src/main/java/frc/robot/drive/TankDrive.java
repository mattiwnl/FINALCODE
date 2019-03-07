package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class TankDrive extends Command {

    public TankDrive() {
        requires(Robot.kDrive);
    }

    @Override
    protected void execute() {
        double angle = Robot.kNavx.gyro.getAngle();
        SmartDashboard.putNumber("angle", angle);
        double left = -Robot.xbox.getRawAxis(1);
        double right = -Robot.xbox.getRawAxis(5);
        boolean toggle1 = Robot.toggles.getRawButton(1);
        if(toggle1 == false){
            Robot.kDrive.driveLeft(left);
            Robot.kDrive.driveRight(right);
        }else if(toggle1 == true){
            Robot.kDrive.driveLeft(right * -1);
            Robot.kDrive.driveRight(left * -1);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}