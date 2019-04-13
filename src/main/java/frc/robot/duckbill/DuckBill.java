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
        boolean xboxA = Robot.xbox.getRawButton(Constants.kXboxButtonAId);
        boolean xboxB = Robot.xbox.getRawButton(Constants.kXboxButtonBId);
        if(xboxA == true){
            Robot.kDuckBill.duckBill(Value.kForward);
        }else if(xboxB == true){
            Robot.kDuckBill.duckBill(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}