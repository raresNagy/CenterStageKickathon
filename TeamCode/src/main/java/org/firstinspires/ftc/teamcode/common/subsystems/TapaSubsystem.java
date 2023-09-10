package org.firstinspires.ftc.teamcode.common.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class TapaSubsystem extends SubsystemBase {

    private final Servo servoTapa;

    public TapaSubsystem(Servo servoTapa){
        this.servoTapa = servoTapa;
        register();
    }

    private final double pozitieInitala = 0;
    private final double pozitieFinala = 0;


}
