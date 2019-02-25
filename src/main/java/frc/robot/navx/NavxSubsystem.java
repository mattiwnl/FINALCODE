package frc.robot.navx;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

import com.kauailabs.navx.frc.AHRS;

public class NavxSubsystem extends Subsystem {

    public AHRS gyro = new AHRS(SPI.Port.kMXP);

    public double kPitch = gyro.getPitch();
    public double kYaw = gyro.getYaw();
    public double kAngle = gyro.getAngle();

    public NavxSubsystem() {
        SmartDashboard.putNumber("Pitch", kPitch);
        SmartDashboard.putNumber("Yaw", kYaw);
        SmartDashboard.putNumber("Angle", kAngle);
    }

    @Override
    protected void initDefaultCommand() {
    }
}