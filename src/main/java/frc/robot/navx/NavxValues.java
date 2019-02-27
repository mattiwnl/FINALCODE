package frc.robot.navx;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class NavxValues extends Command {

    boolean done = false;

    public NavxValues() {
        requires(Robot.kNavx);
    }

    @Override
    protected void initialize() {
    }
    
    @Override
    protected void execute() {
        double angle = Robot.kNavx.gyro.getAngle();
        double pitch = Robot.kNavx.gyro.getPitch();
        double yaw = Robot.kNavx.gyro.getYaw();
        SmartDashboard.putNumber("Navx Angle", angle);
        SmartDashboard.putNumber("Navx Pitch", pitch);
        SmartDashboard.putNumber("Navx Yaw", yaw);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}