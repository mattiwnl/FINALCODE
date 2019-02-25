package frc.robot.lift;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import frc.robot.Constants;

public class LiftSubsystem extends Subsystem {

    private static final TalonSRX liftMotor = new TalonSRX(Constants.kLiftMotorId);

    public LiftSubsystem() {
    }

    public void lift(double lift) {
        liftMotor.set(ControlMode.PercentOutput, lift);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Lift());
    }
}