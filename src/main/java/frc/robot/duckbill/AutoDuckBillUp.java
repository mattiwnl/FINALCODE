package frc.robot.duckbill;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Robot;

public class AutoDuckBillUp extends Command {
    
    boolean done = false;

    public AutoDuckBillUp() {
        requires(Robot.kDuckBill);
    }
    
    @Override
    protected void initialize() {
        done = false;
    }

    @Override
    protected void execute() {
        Robot.kDuckBill.duckBill(Value.kForward);
        Timer.delay(1);
        done = true;
    }

    @Override
    protected boolean isFinished() {
        return done;
    }
}