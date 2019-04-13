package frc.robot.scissor;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Robot;
import frc.robot.Constants;

public class Scissor extends Command {
    
    public Scissor() {
        requires(Robot.kScissor);
    }

    @Override
    protected void execute() {
        boolean xboxMattX = Robot.xboxMatt.getRawButton(Constants.kXboxMattButtonXId);
        boolean xboxMattY = Robot.xboxMatt.getRawButton(Constants.kXboxMattButtonYId);
        if(xboxMattX == true) {
            Robot.kScissor.scissor(Value.kReverse);
        }else if(xboxMattY == true) {
            Robot.kScissor.scissor(Value.kForward);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}