package frc.robot.scissor;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoScissorOut extends Command {
    
    boolean done = false;

    public AutoScissorOut() {
        requires(Robot.kScissor);
    }
    
    @Override
    protected void initialize() {
        done = false;
    }

    @Override
    protected void execute() {
        Robot.kScissor.scissor(Value.kForward);
        Timer.delay(.1);
        done = true;
    }

    @Override
    protected boolean isFinished() {
        return done;
    }
}