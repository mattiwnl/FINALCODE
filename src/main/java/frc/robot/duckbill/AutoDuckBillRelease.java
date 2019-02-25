package frc.robot.duckbill;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class AutoDuckBillRelease extends Command {
    
    boolean done = false;

    public AutoDuckBillRelease() {
        requires(Robot.kDuckBill);
    }
    
    @Override
    protected void initialize() {
        done = false;
    }

    @Override
    protected void execute() {
        Robot.kDuckBill.duckBill(Value.kReverse);
        Timer.delay(1);
        done = true;
    }

    @Override
    protected boolean isFinished() {
        return done;
    }
}