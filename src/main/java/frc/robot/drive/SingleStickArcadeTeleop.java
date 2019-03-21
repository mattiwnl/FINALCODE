package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SingleStickArcadeTeleop extends Command {

    public SingleStickArcadeTeleop() {
        requires(Robot.kDrive);
    }

    @Override
    protected void execute() {
        double throttle = -Robot.xbox.getRawAxis(1);
        double turn = Robot.xbox.getRawAxis(0);
        Robot.kDrive.driveLeft(ControlMode.PercentOutput, throttle + turn);
        Robot.kDrive.driveRight(ControlMode.PercentOutput, throttle - turn);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}