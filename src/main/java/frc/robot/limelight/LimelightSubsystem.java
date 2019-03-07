package frc.robot.limelight;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Servo;

import frc.robot.Constants;

public class LimelightSubsystem extends Subsystem {

    private final Servo llServo = new Servo(Constants.kLLServoId);

    public LimelightSubsystem() {
    }

    public void LLservo(double servoValue) {
        llServo.set(servoValue);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LLServo());
    }
}