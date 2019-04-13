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
        if(xboxMattPOV == 315 || xboxMattPOV == 0 || xboxMattPOV == 45) {
            Robot.kCamCyl.camCyls(Value.kReverse);
        }else if(xboxMattPOV == 135 || xboxMattPOV == 180 || xboxMattPOV == 225) {
            Robot.kCamCyl.camCyls(Value.kForward);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}