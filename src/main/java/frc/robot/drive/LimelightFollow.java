package frc.robot.drive;

import edu.wpi.first.wpilibj.command.Command;

public class LimelightFollow extends Command {

    double llX = Robot.kLimelight.x;
    double llArea = Robot.kLimelight.area;

    public LimelightFollow() {
        requires(Robot.kDrive);
        requires(Robot.kLimelight);
    }
    
    @Override
    protected void execute() {
        if(llX == 0 && llArea == 0) { // Doesn't move if the camera detects nothing

            Robot.kDrive.driveLeft(0);
            Robot.kDrive.driveRight(0);

        }else if(llX != 0 || llArea != 0) { // Moves only if the camera detects an object

            if(llX > 1) {                                    // Turns RIGHT until less than 2
                Robot.kDrive.driveLeft(-.125);
                Robot.kDrive.driveRight(.125);  
            }else if(llX < -1) {                             // Turns LEFT until greater than -2
                Robot.kDrive.driveLeft(.125);
                Robot.kDrive.driveRight(-.125);
            }else if(llX < 1 && llX > -1) {                  // Once the X is between -1 and 1 it goes into the area value

                if(llArea < 19.5) {                          // Drives FORWARD until area is greater than 19.5
                    Robot.kDrive.driveLeft(.125);
                    Robot.kDrive.driveRight(.125);
                }else if(llArea > 20.5) {                    // Drives BACKWARD until area is less than 20.5
                    Robot.kDrive.driveLeft(-.125);
                    Robot.kDrive.driveRight(-.125);
                }else if(llArea > 19.5 && llArea < 20.5) {   // Stops if your X is inbetween -1 and 1 and the Area is between 19.5 and 20.5
                    Robot.kDrive.driveLeft(0);
                    Robot.kDrive.driveRight(0);
                }
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
