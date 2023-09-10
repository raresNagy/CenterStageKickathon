package org.firstinspires.ftc.teamcode.common.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;

public class LiftSubsystem extends SubsystemBase {
    private final Motor motorLift;

    public LiftSubsystem(Motor motorLift) {
        this.motorLift = motorLift;
        register();
    }




    private final double PULLEY_RADIUS = 0;
    private final double GEAR_RATIO = 1;
    private final double TICKS_PER_REV = 537.7;
    private final double ANGLE = 0;
    private final double INCH_IN_CM = 2.54;


    private double encoderTicksToCm(int ticks) {
        return (PULLEY_RADIUS * 2 * Math.PI * GEAR_RATIO * ticks / TICKS_PER_REV) * INCH_IN_CM;
    }


    private double encoderTicksToHeight(int ticks) {
        return encoderTicksToCm(ticks) *  Math.sin(ANGLE);
    }





}
