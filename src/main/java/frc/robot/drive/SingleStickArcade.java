package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class SingleStickArcade extends Command {

    public SingleStickArcade() {
        requires(Robot.kDrive);
    }

    @Override
    protected void execute() {
        double angle = Robot.kNavx.gyro.getAngle();
        SmartDashboard.putNumber("angle", angle);
        double throttle = -Robot.xbox.getRawAxis(1);
        double turn = Robot.xbox.getRawAxis(0);
        boolean toggle1 = Robot.toggles.getRawButton(1);
        if(toggle1 == false){
            Robot.kDrive.driveLeft(throttle + turn);
            Robot.kDrive.driveRight(throttle - turn);
        }else if(toggle1 == true){
            Robot.kDrive.driveLeft((throttle - turn) * -1);
            Robot.kDrive.driveRight((throttle + turn) * -1);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}