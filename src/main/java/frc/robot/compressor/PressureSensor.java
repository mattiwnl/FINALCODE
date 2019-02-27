package frc.robot.compressor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class PressureSensor extends Command {

    AnalogInput psiSensor = Robot.kCompressor.pneumaticPSI;

    public PressureSensor() {
        requires(Robot.kCompressor);
    }

    @Override
    protected void execute() {
        double voltage = psiSensor.getVoltage();
        double pressure = (voltage * 200) / 5;
        SmartDashboard.putNumber("Tank Pressure", pressure);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}