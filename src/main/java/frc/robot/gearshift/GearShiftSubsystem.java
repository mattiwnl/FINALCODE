package frc.robot.gearshift;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class GearShiftSubsystem extends Subsystem {

    private static final DoubleSolenoid gearShift = new DoubleSolenoid(0, 1);

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