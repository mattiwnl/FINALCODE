package frc.robot.scissor;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class Scissor extends Command {
    
    public Scissor() {
        requires(Robot.kScissor);
    }

    @Override
    protected void execute() {
        boolean toggle7 = Robot.toggles.getRawButton(Constants.kToggle7Id);
        if(toggle7 == true) {
            Robot.kScissor.scissor(Value.kForward);
        }else if(toggle7 == false) {
            Robot.kScissor.scissor(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}