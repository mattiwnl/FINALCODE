package frc.robot.compressor;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;

public class CompressorSubsystem extends Subsystem {

    AnalogInput pneumaticPSI = new AnalogInput(1);
    Compressor compressor = new Compressor(0);
    
    public CompressorSubsystem() {
    }

    public void CompressorRun(boolean Compress) {
        compressor.setClosedLoopControl(Compress);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CompressorCMD());
    }
}