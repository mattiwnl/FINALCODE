package frc.robot.camlift;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import frc.robot.Constants;

public class CamLiftSubsystem extends Subsystem {

    private static final TalonSRX camLiftMotor = new TalonSRX(Constants.kCamLiftMotorId);

    public CamLiftSubsystem() {
    }

    public void camLift(double camLift) {
        camLiftMotor.set(ControlMode.PercentOutput, camLift);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CamLift());
    }
}