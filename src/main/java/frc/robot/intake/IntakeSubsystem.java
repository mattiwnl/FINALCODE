package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class IntakeSubsystem extends Subsystem {

    private static final VictorSPX leftIntake = new VictorSPX(Constants.kLeftIntakeId);
    private static final VictorSPX rightIntake = new VictorSPX(Constants.kRightIntakeId);

    public IntakeSubsystem() {
        rightIntake.setInverted(true);
    }

    public void intakeLeft(double left) {
        leftIntake.set(ControlMode.PercentOutput, left);
    }

    public void intakeRight(double right){
        rightIntake.set(ControlMode.PercentOutput, right);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Intake());
    }
}