package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;

public class DriveSubsystem extends Subsystem {

    private static final TalonSRX leftMaster = new TalonSRX(Constants.kLeftMasterId);
    private static final TalonSRX leftSlave1 = new TalonSRX(Constants.kLeftSlave1Id);
    private static final TalonSRX leftSlave2 = new TalonSRX(Constants.kLeftSlave2Id);
    private static final TalonSRX rightMaster = new TalonSRX(Constants.kRightMasterId);
    private static final TalonSRX rightSlave1 = new TalonSRX(Constants.kRightSlave1Id);
    private static final TalonSRX rightSlave2 = new TalonSRX(Constants.kRightSlave2Id);

    public DriveSubsystem() {
        // Factory default so there is no funny business
        leftMaster.configFactoryDefault();
        leftSlave1.configFactoryDefault();
        leftSlave2.configFactoryDefault();
        rightMaster.configFactoryDefault();
        rightSlave1.configFactoryDefault();
        rightSlave2.configFactoryDefault();

        // Follows
        leftSlave1.follow(leftMaster);
        leftSlave2.follow(leftMaster);
        rightSlave1.follow(rightMaster);
        rightSlave2.follow(rightMaster);

        // Invert Right
        rightMaster.setInverted(true);
        rightSlave1.setInverted(true);
        rightSlave2.setInverted(true);

        // Brake Motors
        leftMaster.setNeutralMode(NeutralMode.Brake);
        rightMaster.setNeutralMode(NeutralMode.Brake);

        // Left Configs
        leftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        leftMaster.setSelectedSensorPosition(0, 0, 0);
        leftMaster.setSensorPhase(false);
        leftMaster.configOpenloopRamp(.25, 0);

        // Right Configs
        rightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        rightMaster.setSelectedSensorPosition(0, 0, 0);
        rightMaster.setSensorPhase(false);
        rightMaster.configOpenloopRamp(.25, 0);
    }

    public void driveLeft(double left) {
        // Left Side DriveTrain
        leftMaster.set(ControlMode.PercentOutput, left);
    }
    public void driveRight(double right) {
        // Right Side DriveTrain
        rightMaster.set(ControlMode.PercentOutput, right);
    }
    
    public double getLeft() {
        return leftMaster.getSelectedSensorPosition(1) / 1440 * Math.PI * Constants.kWheelDiameter;
    }

    public double getRight() {
        return rightMaster.getSelectedSensorPosition(1) / 1440 * Math.PI * Constants.kWheelDiameter;
    }

    @Override
    protected void initDefaultCommand() {
    }
}