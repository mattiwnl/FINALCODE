package frc.robot.gearshift;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class GearShift extends Command {
    
    public GearShift() {
        requires(Robot.kGearShift);
    }

    @Override
    protected void execute() {
        boolean lBumper = Robot.xbox.getRawButton(Constants.kXboxLeftBumperId);
        boolean rBumper = Robot.xbox.getRawButton(Constants.kXboxRightBumperId);
        if(lBumper == true) {
            Robot.kGearShift.gearShift(Value.kForward);
        }else if(rBumper == true) {
            Robot.kGearShift.gearShift(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}