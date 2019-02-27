package frc.robot.autogroup;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.drive.*;
import frc.robot.duckbill.*;
import frc.robot.navx.*;
import frc.robot.scissor.*;

public class TRTL extends CommandGroup {

    public TRTL() {
        addSequential(new TurnToRight());
        addSequential(new TurnToLeft());
    }
}