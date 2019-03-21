package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Auto extends Command {

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
        if(lla <= 25){
            if(angle < 1 && angle > -1){
                Robot.kDrive.driveLeft(ControlMode.PercentOutput, .5);
                Robot.kDrive.driveRight(ControlMode.PercentOutput, .5);
            }else if(angle > 1 && angle < 3){
                Robot.kDrive.driveLeft(ControlMode.PercentOutput, -.25);
                Robot.kDrive.driveRight(ControlMode.PercentOutput, .25);
            }else if(angle > 3){
                Robot.kDrive.driveLeft(ControlMode.PercentOutput, -.35);
                Robot.kDrive.driveRight(ControlMode.PercentOutput, .35);
            }else if(angle < -1 && angle > -3){
                Robot.kDrive.driveLeft(ControlMode.PercentOutput, .25);
                Robot.kDrive.driveRight(ControlMode.PercentOutput, -.25);
            }else if(angle < -3){
                Robot.kDrive.driveLeft(ControlMode.PercentOutput, .35);
                Robot.kDrive.driveRight(ControlMode.PercentOutput, -.35);
            }
        }else if(lla > 25){
            Robot.kDrive.driveLeft(ControlMode.PercentOutput, 0);
            Robot.kDrive.driveRight(ControlMode.PercentOutput, 0);
            Timer.delay(1);
            Robot.kDuckBill.duckBill(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}