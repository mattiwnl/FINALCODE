package frc.robot.intake;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.Constants;

public class Intake extends Command {
    
    public Intake() {
        requires(Robot.kIntake);
    }

    @Override
    protected void execute() {
        double xboxLeftTrigger = Robot.xbox.getRawAxis(Constants.kXboxLeftTriggerId);
        double xboxRightTrigger = Robot.xbox.getRawAxis(Constants.kXboxRightTriggerId);
        if(xboxRightTrigger > .1) {
            Robot.kIntake.intakeLeft(.25);
            Robot.kIntake.intakeRight(.25);
        }else if(xboxLeftTrigger > .1) {
            Robot.kIntake.intakeLeft(-.25);
            Robot.kIntake.intakeRight(-.25);
        }else{
            Robot.kIntake.intakeLeft(0);
            Robot.kIntake.intakeRight(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}