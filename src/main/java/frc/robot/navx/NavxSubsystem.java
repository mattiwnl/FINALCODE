package frc.robot.navx;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.*;

import com.kauailabs.navx.frc.AHRS;

public class NavxSubsystem extends Subsystem {

    public AHRS gyro = new AHRS(SPI.Port.kMXP);

    public NavxSubsystem() {
    }

    @Override
    protected void initDefaultCommand() {
    }

}