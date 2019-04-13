package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TankDriveTeleop extends Command {

	public TankDriveTeleop() {
		requires(Robot.kDrive);
	}

	@Override
	protected void execute() {
		double xboxLeft = -Robot.xbox.getRawAxis(1);
		double xboxRight = -Robot.xbox.getRawAxis(5);
		Robot.kDrive.driveLeft(ControlMode.PercentOutput, xboxLeft);
		Robot.kDrive.driveRight(ControlMode.PercentOutput, xboxRight);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}

// THIS IS ONLY HERE FOR TESTING DRIVERS