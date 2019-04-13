package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Auto extends Command {

    public double kP = .01;
    public double kL = .02;

    public Auto() {
        requires(Robot.kDrive);
        requires(Robot.kDuckBill);
        requires(Robot.kScissor);
    }

    @Override
    protected void initialize() {
        Robot.kScissor.scissor(Value.kForward);
    }

    @Override
    protected void execute() {
        double angle = Robot.gyro.getAngle();
        double lla = Robot.area;
        Robot.kDrive.driveLeft(ControlMode.PercentOutput, (.5 - kL*lla) + kP*angle);
        Robot.kDrive.driveRight(ControlMode.PercentOutput, (.5 - kL*lla) - kP*angle);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
