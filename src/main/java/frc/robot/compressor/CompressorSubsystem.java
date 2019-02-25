package frc.robot.compressor;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CompressorSubsystem extends Subsystem {

    Compressor compressor = new Compressor(0);
    
    public CompressorSubsystem() {
    }

    public void CompressorRun(boolean bCompress) {
        compressor.setClosedLoopControl(bCompress);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CompressorCMD());
    }
}