package frc.robot.disabled;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class Disabled extends Command {

    public Disabled() {
        requires(Robot.kCompressor);
        requires(Robot.kDrive);
        requires(Robot.kIntake);
        requires(Robot.kLimelight);
    }

    @Override
    protected void execute() {
        Robot.kCompressor.CompressorRun(false);
        Robot.kDrive.driveLeft(0);
        Robot.kDrive.driveRight(0);
        Robot.kIntake.intakeLeft(0);
        Robot.kIntake.intakeRight(0);
        Robot.kLift.lift(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}