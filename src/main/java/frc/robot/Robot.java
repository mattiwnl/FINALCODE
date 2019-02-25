package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Scheduler;

import frc.robot.autogroup.*;
import frc.robot.compressor.*;
import frc.robot.disabled.*;
import frc.robot.drive.*;
import frc.robot.duckbill.*;
import frc.robot.gearshift.*;
import frc.robot.intake.*;
import frc.robot.lift.Lift;
import frc.robot.lift.LiftSubsystem;
import frc.robot.limelight.*;
import frc.robot.navx.*;
import frc.robot.scissor.*;

public class Robot extends TimedRobot {

    public static Joystick toggles = new Joystick(Constants.kToggleSwitchesPort);
    public static Joystick xbox = new Joystick(Constants.kXboxControllerPort);

    public static CompressorSubsystem kCompressor = new CompressorSubsystem();
    public static DriveSubsystem kDrive = new DriveSubsystem();
    public static GearShiftSubsystem kGearShift = new GearShiftSubsystem();
    public static DuckBillSubsystem kDuckBill = new DuckBillSubsystem();
    public static IntakeSubsystem kIntake = new IntakeSubsystem();
    public static LimelightSubsystem kLimelight = new LimelightSubsystem();
    public static LiftSubsystem kLift = new LiftSubsystem();
    public static NavxSubsystem kNavx = new NavxSubsystem();
    public static ScissorSubsystem kScissor = new ScissorSubsystem();

    @Override
    public void robotInit() {}
    @Override
    public void robotPeriodic() {
        new LLModes().start();
        new LLPosition().start();
        new Compressor().start();
        Scheduler.getInstance().run();
    }
    @Override
    public void disabledInit() {}
    @Override
    public void disabledPeriodic() {
    } 
    @Override
    public void autonomousInit() {}
    @Override
    public void autonomousPeriodic() {
        boolean toggle10 = toggles.getRawButton(Constants.kToggle10Id);
        // new LimelightFollow().start();
        if(toggle10 == false) {
            new LeftSideAuto().start();
        }else if(toggle10 == true) {
            new RightSideAuto().start();
        }
    }
    @Override
    public void teleopInit() {}
    @Override
    public void teleopPeriodic() {
        new Drive().start();
        new GearShift().start();
        new Scissor().start();
        new DuckBill().start();
        new Intake().start();
        new Lift().start();
    }
}
