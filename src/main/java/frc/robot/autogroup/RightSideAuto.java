package frc.robot.autogroup;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.drive.*;
import frc.robot.duckbill.*;
import frc.robot.navx.*;
import frc.robot.scissor.*;

public class RightSideAuto extends CommandGroup {

    public RightSideAuto() {
        addParallel(new AutoScissorOut());
        addSequential(new ToCargoShip());
        addSequential(new AutoDuckBillRelease());
        addSequential(new BackOffCargoShip()); 
        addSequential(new TurnToRight());
    }
}