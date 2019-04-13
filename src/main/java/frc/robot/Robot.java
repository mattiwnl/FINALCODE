package frc.robot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.*;

import frc.robot.camcyl.*;
import frc.robot.camlift.*;
import frc.robot.camwheel.*;
import frc.robot.drive.*;
import frc.robot.duckbill.*;
import frc.robot.gearshift.*;
import frc.robot.scissor.*;

public class Robot extends TimedRobot {
// Controllers
	public static Joystick xboxMatt = new Joystick(Constants.kXboxMattPort);
	public static Joystick xbox = new Joystick(Constants.kXboxControllerPort);
// Drive
	public static DriveSubsystem kDrive = new DriveSubsystem();
	public static GearShiftSubsystem kGearShift = new GearShiftSubsystem();
// Hatch
	public static ScissorSubsystem kScissor = new ScissorSubsystem();
	public static DuckBillSubsystem kDuckBill = new DuckBillSubsystem();
// Cam
	public static CamCylinderSubsystem kCamCyl = new CamCylinderSubsystem();
	public static CamLiftSubsystem kCamLift = new CamLiftSubsystem();
	public static CamWheelSubsystem kCamWheel = new CamWheelSubsystem();
// Gyro
	public static AHRS gyro = new AHRS(SPI.Port.kMXP);
// Compressor
	public Compressor compressor = new Compressor(0);
// Limelight Data
	public NetworkTableEntry tx;
	public NetworkTableEntry ty;
	public NetworkTableEntry ta;
	public static double x;
	public static double y;
	public static double area;

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

		if(xboxMatt.getRawButton(Constants.kXboxMattButtonAId) == true){
			compressor.setClosedLoopControl(true);
		}else if(xboxMatt.getRawButton(Constants.kXboxMattButtonBId) == true){
			compressor.setClosedLoopControl(true);
		}
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
		new SplitArcadeTeleop().start();
		new GearShift().start();
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
		new SplitArcadeTeleop().start();
		new GearShift().start();
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