package frc.robot;

public class Constants {
    // Toggle
    public static final int kToggleSwitchesPort = 0;
        public static final int kToggle1Id = 1;             // Drive Method   |  True == Ball   False == Hatch
        public static final int kToggle2Id = 2;             // Compressor     |  True == On     False == Off
        public static final int kToggle3Id = 3;             // Unused         |  True ==        False == 
        public static final int kToggle4Id = 4;             // Unused         |  True ==        False == 
        public static final int kToggle5Id = 5;             // Unused         |  True ==        False == 
        public static final int kToggle6Id = 6;             // Duck Bill      |  True == Up     False == Down
        public static final int kToggle7Id = 7;             // Scissor Arm    |  True == Out    False == In
        public static final int kToggle8Id = 8;             // Unused         |  True ==        False == 
        public static final int kToggle9Id = 9;             // Limelight Mode |  True == Camera False == VisionProcessing
        public static final int kToggle10Id = 10;           // Unused         |  True ==        False == 

    // Xbox
    public static final int kXboxControllerPort = 1;
        public static final int kXboxButtonAId = 1;         // Intake Ball
        public static final int kXboxButtonBId = 2;         // Outtake Ball
        public static final int kXboxButtonXId = 3;         // Lower Intake Lift
        public static final int kXboxButtonYId = 4;         // Raise Intake Lift
        public static final int kXboxLeftBumperId = 5;      // Shift Low Gear
        public static final int kXboxRightBumperId = 6;     // Shift High Gear
        public static final int kXboxButtonStartId = 7;     // Unused
        public static final int kXboxButtonSelectId = 8;    // Unused
    
    // Drive Train Talons
    public static final int kLeftMasterId = 4;
    public static final int kLeftSlave1Id = 5;
    public static final int kLeftSlave2Id = 6;
	public static final int kRightMasterId = 1;
    public static final int kRightSlave1Id = 2;
    public static final int kRightSlave2Id = 3;

    // Intake Victors
    public static final int kLeftIntakeId = 1;
    public static final int kRightIntakeId = 2;

    // Lift Talon
    public static final int kLiftMotorId = 7;

    // Limelight Servo
    public static final int kLLServoId = 1;

    // DoubleSolenoid
    public static final int kHighGearId = 0;
    public static final int kLowGearId = 1;
    public static final int kScissorInId = 2;
    public static final int kScissorOutId = 3;
    public static final int kDuckBillUpId = 4;
    public static final int kDuckBillDownId = 5;

    // Other Constants
    public static final int kWheelDiameter = 6;
}
