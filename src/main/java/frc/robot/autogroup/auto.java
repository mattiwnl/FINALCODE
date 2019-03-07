package frc.robot.autogroup;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.Robot;
import frc.robot.drive.ToCargoShip;
import frc.robot.duckbill.AutoDuckBillRelease;

public class auto extends CommandGroup {

    public auto() {
    }

    @Override
    protected void execute() {
        addSequential(new ToCargoShip());
        addSequential(new AutoDuckBillRelease());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}