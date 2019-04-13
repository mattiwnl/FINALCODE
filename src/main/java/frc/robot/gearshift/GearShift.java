package frc.robot.gearshift;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Robot;
import frc.robot.Constants;

public class GearShift extends Command {
    
    public GearShift() {
        requires(Robot.kGearShift);
    }
    
    @Override
    protected void execute() {
        boolean lStickClick = Robot.xbox.getRawButton(Constants.kXboxLeftStickId);
        boolean rStickClick = Robot.xbox.getRawButton(Constants.kXboxRightStickId);
        boolean lBumper = Robot.xbox.getRawButton(Constants.kXboxLeftBumperId);
        boolean rBumper = Robot.xbox.getRawButton(Constants.kXboxRightBumperId);
        if(lStickClick == true || lBumper == true) {
            Robot.kGearShift.gearShift(Value.kForward);
        }else if(rStickClick == true || rBumper == true) {
            Robot.kGearShift.gearShift(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}