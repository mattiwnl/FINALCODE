package frc.robot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.*;
import frc.robot.camcyl.CamCylinder;
import frc.robot.camcyl.CamCylinderSubsystem;
import frc.robot.camlift.CamLift;
import frc.robot.camlift.CamLiftSubsystem;
import frc.robot.camwheel.CamWheel;
import frc.robot.camwheel.CamWheelSubsystem;
import frc.robot.drive.*;
import frc.robot.duckbill.*;
import frc.robot.gearshift.*;
import frc.robot.intake.*;
import frc.robot.lift.*;
import frc.robot.scissor.*;

public class Robot extends TimedRobot {
// Controllers
    public static Joystick xboxMatt = new Joystick(Constants.kXboxMattPort);
    public static Joystick xbox = new Joystick(Constants.kXboxControllerPort);

// Drive
    public static DriveSubsystem kDrive = new DriveSubsystem();
    public static GearShiftSubsystem kGearShift = new GearShiftSubsystem();
// Ball
    public static IntakeSubsystem kIntake = new IntakeSubsystem();
    public static LiftSubsystem kLift = new LiftSubsystem();
// Hatch
    public static ScissorSubsystem kScissor = new ScissorSubsystem();
    public static DuckBillSubsystem kDuckBill = new DuckBillSubsystem();
// Cam
    public static CamCylinderSubsystem kCamCyl = new CamCylinderSubsystem();
    public static CamLiftSubsystem kCamLift = new CamLiftSubsystem();
    public static CamWheelSubsystem kCamWheel = new CamWheelSubsystem();

// Gyro
    public AHRS gyro = new AHRS(SPI.Port.kMXP);

// Compressor
    public Compressor compressor = new Compressor(0);

// Servo
    public Servo llServo = new Servo(Constants.kLLServoId);
// Limelight Data
    public NetworkTableEntry tx;
    public NetworkTableEntry ty;
    public NetworkTableEntry ta;

    public static double x;
    public static double y;
    public static double area;

// Drives
    public static double driveCounter = 0;

    @Override
    public void robotInit() {
// Limelight Initialization
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
    }
    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();

// Limelight Data w/ SmartDashboard
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0);
        area = ta.getDouble(0.0);

        SmartDashboard.putNumber("Limelight X", x);
        SmartDashboard.putNumber("Limelight Y", y);
        SmartDashboard.putNumber("Limelight Area", area);

        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); // LED Off
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1); // Normal Camera
// Gyro w/ SmartDashboard
        double angle = gyro.getAngle();
        SmartDashboard.putNumber("angle", angle);

        compressor.setClosedLoopControl(true);

        llServo.set(1);
    }
    @Override
    public void disabledInit() {
    }
    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    } 
    @Override
    public void autonomousInit() {
    // Drive
        new TankDriveTeleop().start();
        new GearShift().start();
    // Ball
        new Intake().start();
        new Lift().start();
    // Hatch
        new DuckBill().start();
        new Scissor().start();
    // Cam 
        new CamCylinder().start();
        new CamLift().start();
        new CamWheel().start();
    }
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    @Override
    public void teleopInit() {
    // Drive
        new TankDriveTeleop().start();
        new GearShift().start();
    // Ball
        new Intake().start();
        new Lift().start();
    // Hatch
        new DuckBill().start();
        new Scissor().start();
    // Cam 
        new CamCylinder().start();
        new CamLift().start();
        new CamWheel().start();
    }
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}