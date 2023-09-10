package org.firstinspires.ftc.teamcode.common.commands.drivetraincommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.common.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DrivetrainCommand extends CommandBase {
    private final DriveSubsystem drivetrain;
    private final DoubleSupplier forward;
    private final DoubleSupplier turn;
    private final DoubleSupplier strafe;

    public DrivetrainCommand(DriveSubsystem drivetrain, DoubleSupplier forward, DoubleSupplier strafe, DoubleSupplier turn){
        this.drivetrain = drivetrain;
        this.forward = forward;
        this.turn = turn;
        this.strafe = strafe;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.drive(strafe.getAsDouble(), forward.getAsDouble(), turn.getAsDouble());
    }
}
