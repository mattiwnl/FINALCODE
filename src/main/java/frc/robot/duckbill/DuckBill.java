package frc.robot.duckbill;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Robot;
import frc.robot.Constants;

public class DuckBill extends Command {
    
    public DuckBill() {
        requires(Robot.kDuckBill);
    }

    @Override
    protected void execute() {
        boolean xboxMattA = Robot.xboxMatt.getRawButton(Constants.kXboxMattButtonAId);
        boolean xboxMattB = Robot.xboxMatt.getRawButton(Constants.kXboxMattButtonBId);
        if(xboxMattA == true) {
            Robot.kScissor.scissor(Value.kForward);
        }else if(xboxMattB == true) {
            Robot.kScissor.scissor(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}