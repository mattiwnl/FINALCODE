package frc.robot.camwheel;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import frc.robot.Constants;

public class CamWheelSubsystem extends Subsystem {

    private static final VictorSPX leftCamWheel = new VictorSPX(Constants.kLeftCamWheel);
    private static final VictorSPX rightCamWheel = new VictorSPX(Constants.kRightCamWheel);

    public CamWheelSubsystem() {
    }

    public void camWheelLeft(double left) {
        leftCamWheel.set(ControlMode.PercentOutput, left);
    }

    public void camWheelRight(double right){
        rightCamWheel.set(ControlMode.PercentOutput, right);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CamWheel());
    }
}