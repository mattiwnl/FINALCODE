package frc.robot.scissor;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Constants;

public class ScissorSubsystem extends Subsystem {

    public static final DoubleSolenoid scissor = new DoubleSolenoid(Constants.kScissorInId, Constants.kScissorOutId);

    public ScissorSubsystem() {
    }

    public void scissor(Value sciPos) {
        scissor.set(sciPos);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Scissor());
    }
}