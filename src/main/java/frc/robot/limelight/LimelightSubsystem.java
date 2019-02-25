package frc.robot.limelight;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class LimelightSubsystem extends Subsystem {

    public NetworkTableEntry tx;
    public NetworkTableEntry ty;
    public NetworkTableEntry ta;

    public double x;
    public double y;
    public double area;

    private final Servo llServo = new Servo(Constants.kLLServoId);

    public LimelightSubsystem() {
        // Limelight Initialization
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        // X, Y, Area Values w/ Shuffleboard
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0);
        area = ta.getDouble(0.0);
        SmartDashboard.putNumber("Limelight Area", area);
        SmartDashboard.putNumber("Limelight X", x);
        SmartDashboard.putNumber("Limelight Y", y);
    }

    public void LLServo(double servoValue) {
        llServo.set(servoValue);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LLModes());
    }
}