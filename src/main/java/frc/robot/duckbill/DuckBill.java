package frc.robot.duckbill;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

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