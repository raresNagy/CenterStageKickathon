package org.firstinspires.ftc.teamcode.common.commands.liftcommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.common.subsystems.LiftSubsystem;

import java.util.function.DoubleSupplier;

public class LiftCommand extends CommandBase {
    private final LiftSubsystem lift;
    private DoubleSupplier power;
    public LiftCommand(LiftSubsystem lift, DoubleSupplier power) {
        this.lift = lift;
        this.power = power;
    }

    @Override
    public void execute() {
        lift.setPower(power.getAsDouble());
    }
}
