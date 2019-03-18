package frc.robot.camcyl;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Robot;

public class CamCylinder extends Command {
    
    public CamCylinder() {
        requires(Robot.kCamCyl);
    }

    @Override
    protected void execute() {
        int xboxMattPOV = Robot.xboxMatt.getPOV();
        if(xboxMattPOV == 0) {
            Robot.kCamCyl.camCyls(Value.kForward);
        }else if(xboxMattPOV == 180) {
            Robot.kCamCyl.camCyls(Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}