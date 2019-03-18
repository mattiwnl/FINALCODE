package frc.robot.duckbill;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Constants;

public class DuckBillSubsystem extends Subsystem {

    public static final DoubleSolenoid duckBill = new DoubleSolenoid(Constants.kDuckBillUpId, Constants.kDuckBillDownId);

    public DuckBillSubsystem() {
    }

    public void duckBill(Value duckPos) {
        duckBill.set(duckPos);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DuckBill());
    }
}