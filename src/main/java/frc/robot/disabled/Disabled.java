package frc.robot.disabled;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Disabled extends Command {

    public Disabled() {
        requires(Robot.kDrive);
        requires(Robot.kIntake);
        requires(Robot.kScissor);
        requires(Robot.kLimelight);
        requires(Robot.kCompressor);
        requires(Robot.kDuckBill);
    }

    @Override
    protected void execute() {
        Robot.kDrive.driveLeft(0);
        Robot.kDrive.driveRight(0);
        Robot.kLift.lift(0);
        Robot.kIntake.intakeLeft(0);
        Robot.kIntake.intakeRight(0);
        Robot.kScissor.scissor(Value.kReverse);
        Robot.kDuckBill.duckBill(Value.kForward);
        Robot.kCompressor.CompressorRun(false);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}