package frc.robot.camcyl;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class CamCylinderSubsystem extends Subsystem {

    private static final DoubleSolenoid camCylinders = new DoubleSolenoid(Constants.kCamCylOutId, Constants.kCamCylInId);

    public CamCylinderSubsystem() {
    }

    public void camCyls(Value liftBack){
        camCylinders.set(liftBack);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CamCylinder());
    }
}