package org.firstinspires.ftc.teamcode.common.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class DriveSubsystem extends SubsystemBase {
    private final MecanumDrive drivetrain;

    public DriveSubsystem(MotorEx frontRightMotor, MotorEx frontLeftMotor, MotorEx backRightMotor, MotorEx backLeftMotor){
        drivetrain = new MecanumDrive(true, frontRightMotor, frontRightMotor, backLeftMotor, backRightMotor);
        register();
    }

    public void drive(double strafeSpeed, double forwardSpeed, double turnSpeed){
        drivetrain.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed, true);
    }
}
