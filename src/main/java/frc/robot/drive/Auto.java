package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Auto extends Command {

    public double kP = .3;

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
        if(lla <= 5){
            Robot.kDrive.driveLeft(ControlMode.PercentOutput, .6 + kP*angle);
            Robot.kDrive.driveRight(ControlMode.PercentOutput, .6 - kP*angle);
        }else if(lla > 5 && lla <= 10){
			Robot.kDrive.driveLeft(ControlMode.PercentOutput, .4 + kP*angle);
			Robot.kDrive.driveRight(ControlMode.PercentOutput, .4 - kP*angle);
		}else if(){
			Robot.kDrive.driveLeft(ControlMode.PercentOutput, .25 + kP*angle);
			Robot.kDrive.driveRight(ControlMode.PercentOutput, .25 - kP*angle);
		}
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}