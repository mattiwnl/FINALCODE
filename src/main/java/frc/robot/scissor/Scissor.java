package frc.robot.scissor;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Robot;
import frc.robot.Constants;

public class Scissor extends Command {
    
    public Scissor() {
        requires(Robot.kScissor);
    }

    @Override
    protected void execute() {
        boolean toggle7 = Robot.toggles.getRawButton(Constants.kToggle7Id);
        if(toggle7 == true) {
            SmartDashboard.putString("Scissor", "Out");
            Robot.kScissor.scissor(Value.kForward);
        }else if(toggle7 == false) {
            SmartDashboard.putString("Scissor", "In");
            Robot.kScissor.scissor(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}