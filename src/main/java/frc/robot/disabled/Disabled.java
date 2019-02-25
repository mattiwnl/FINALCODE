package frc.robot.disabled;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Robot;

public class Disabled extends Command {

    public Disabled() {
        requires(Robot.kCompressor);
        requires(Robot.kDrive);
        requires(Robot.kDuckBill);
        requires(Robot.kIntake);
        requires(Robot.kLimelight);
        requires(Robot.kScissor);
    }

    @Override
    protected void execute() {
        Robot.kCompressor.CompressorRun(false);
        Robot.kDrive.driveLeft(0);
        Robot.kDrive.driveRight(0);
        Robot.kDuckBill.duckBill(Value.kForward);
        Robot.kIntake.intakeLeft(0);
        Robot.kIntake.intakeRight(0);
        Robot.kLift.lift(0);
        Robot.kScissor.scissor(Value.kReverse);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}