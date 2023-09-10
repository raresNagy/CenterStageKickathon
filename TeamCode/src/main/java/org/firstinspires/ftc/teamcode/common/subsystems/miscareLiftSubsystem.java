package org.firstinspires.ftc.teamcode.common.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class miscareLiftSubsystem extends SubsystemBase {

    private final Servo servoMiscareLift;

    public miscareLiftSubsystem(Servo servoMiscareLift){
        this.servoMiscareLift = servoMiscareLift;
    }

    private final double poizitieInitiala = 0;
    private final double pozitieFinala = 0;

}
