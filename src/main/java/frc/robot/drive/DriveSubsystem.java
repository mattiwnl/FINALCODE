package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;

public class DriveSubsystem extends Subsystem {

    private static final TalonSRX leftMaster = new TalonSRX(Constants.kLeftMasterId);
    private static final TalonSRX leftSlave1 = new TalonSRX(Constants.kLeftSlave1Id);
    private static final TalonSRX rightMaster = new TalonSRX(Constants.kRightMasterId);
    private static final TalonSRX rightSlave1 = new TalonSRX(Constants.kRightSlave1Id);

    public DriveSubsystem() {
        // Follows
        leftSlave1.follow(leftMaster);
        rightSlave1.follow(rightMaster);

        // Invert Right
        rightMaster.setInverted(true);
        rightSlave1.setInverted(true);

        // Brake Motors
        leftMaster.setNeutralMode(NeutralMode.Brake);
        rightMaster.setNeutralMode(NeutralMode.Brake);

        // leftMaster.configOpenloopRamp(.25, 0);
        leftMaster.configNeutralDeadband(.175, 0);

        // rightMaster.configOpenloopRamp(.25, 0); 
        rightMaster.configNeutralDeadband(.175, 0);
    }

    public void driveLeft(ControlMode mode, double left) {
        // Left Side DriveTrain
        leftMaster.set(mode, left);
    }
    public void driveRight(ControlMode mode, double right) {
        // Right Side DriveTrain
        rightMaster.set(mode, right);
    }

    @Override
    protected void initDefaultCommand() {
    }
}