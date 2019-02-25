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
        boolean toggle6 = Robot.toggles.getRawButton(Constants.kToggle6Id);
        if(toggle6 == true) {
            Robot.kDuckBill.duckBill(Value.kForward);
        }else if(toggle6 == false) {
            Robot.kDuckBill.duckBill(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}