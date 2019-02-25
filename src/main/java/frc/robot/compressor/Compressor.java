package frc.robot.compressor;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CompressorCMD extends Command {

    public CompressorCMD() {
        requires(Robot.kCompressor);
    }

    @Override
    protected void execute() {
        boolean toggle2 = Robot.toggles.getRawButton(2);
        if(toggle2 == true) {
            Robot.kCompressor.CompressorRun(true);
        }else if(toggle2 == false) {
            Robot.kCompressor.CompressorRun(false);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}