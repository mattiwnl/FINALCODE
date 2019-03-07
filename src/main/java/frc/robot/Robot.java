package frc.robot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.networktables.*;

import frc.robot.compressor.*;
import frc.robot.disabled.*;
import frc.robot.drive.*;
import frc.robot.duckbill.*;
import frc.robot.gearshift.*;
import frc.robot.intake.*;
import frc.robot.lift.*;
import frc.robot.limelight.*;
import frc.robot.navx.*;
import frc.robot.scissor.*;

public class Robot extends TimedRobot {

    public static Joystick toggles = new Joystick(Constants.kToggleSwitchesPort);
    public static Joystick xbox = new Joystick(Constants.kXboxControllerPort);

    public static CompressorSubsystem kCompressor = new CompressorSubsystem();
    public static DriveSubsystem kDrive = new DriveSubsystem();
    public static DuckBillSubsystem kDuckBill = new DuckBillSubsystem();
    public static GearShiftSubsystem kGearShift = new GearShiftSubsystem();
    public static IntakeSubsystem kIntake = new IntakeSubsystem();
    public static LiftSubsystem kLift = new LiftSubsystem();
    public static LimelightSubsystem kLimelight = new LimelightSubsystem();
    public static NavxSubsystem kNavx = new NavxSubsystem();
    public static ScissorSubsystem kScissor = new ScissorSubsystem();

    public NetworkTableEntry tx;
    public NetworkTableEntry ty;
    public NetworkTableEntry ta;

    public static double x;
    public static double y;
    public static double area;

    @Override
    public void robotInit() {
        new Compressor().start();
        new LLServo().start();
        // Limelight Initialization
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
    }
    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
        // X, Y, Area Values w/ Shuffleboard
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0);
        area = ta.getDouble(0.0);
        SmartDashboard.putNumber("Limelight X", x);
        SmartDashboard.putNumber("Limelight Y", y);
        SmartDashboard.putNumber("Limelight Area", area);
        boolean toggle9 = Robot.toggles.getRawButton(Constants.kToggle9Id);
        if(toggle9 == false) {
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); // LED On
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); // Vision Processing
        }else if(toggle9 == true) {
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); // LED Off
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1); // Normal Camera
        }
    }
    @Override
    public void disabledInit() {
        new Disabled().start();
    }
    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    } 
    @Override
    public void autonomousInit() {
        // new LimelightFollow().start();
        // new NavxDriveStraight().start();
        // new LimelightStraight().start();
        new TurnToBack().start();
    }
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    @Override
    public void teleopInit() {
        // new TankDrive().start();
        // new SplitArcade().start();
        new SingleStickArcade().start();
        new DuckBill().start();
        new GearShift().start();
        new Intake().start();
        new Lift().start();
        new Scissor().start();
    }
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}