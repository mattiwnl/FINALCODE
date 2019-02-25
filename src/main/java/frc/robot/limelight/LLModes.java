package frc.robot.limelight;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.networktables.*;

import frc.robot.Robot;
import frc.robot.Constants;

public class LLModes extends Command {

    public LLModes() {
        requires(Robot.kLimelight);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        boolean toggle9 = Robot.toggles.getRawButton(Constants.kToggle9Id);
        if(toggle9 == false) {
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); // LED On
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); // Vision Processing
        }else if(toggle9 == true) {
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); // LED Off
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1); // Normal Camera
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}