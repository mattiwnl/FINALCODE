package frc.robot.gearshift;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class GearShiftSubsystem extends Subsystem {

    private static final DoubleSolenoid gearShift = new DoubleSolenoid(Constants.kHighGearId, Constants.kLowGearId);

    public GearShiftSubsystem() {
    }

    public void gearShift(Value shift){
        gearShift.set(shift);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new GearShift());
    }
}