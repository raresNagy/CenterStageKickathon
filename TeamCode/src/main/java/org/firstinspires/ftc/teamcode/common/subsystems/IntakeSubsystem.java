package org.firstinspires.ftc.teamcode.common.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class IntakeSubsystem extends SubsystemBase {
    private final Motor intakeMotor;
    public IntakeSubsystem(Motor intakeMotor){
        this.intakeMotor = intakeMotor;
        intakeMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        register();
    }

    public void set(double power) {
        intakeMotor.set(power);
    }

    public void startIntake() {
        intakeMotor.set(1);
    }

    public void stopIntake() {
        intakeMotor.set(0);
    }
}
