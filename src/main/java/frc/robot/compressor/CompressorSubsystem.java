package frc.robot.compressor;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

public class CompressorSubsystem extends Subsystem {

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