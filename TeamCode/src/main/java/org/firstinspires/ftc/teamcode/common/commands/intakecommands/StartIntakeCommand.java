package org.firstinspires.ftc.teamcode.common.commands.intakecommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.common.subsystems.IntakeSubsystem;

public class StartIntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;
    public StartIntakeCommand(IntakeSubsystem intakeSubsystem){
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    public void initialize() {
        intakeSubsystem.startIntake();
    }




    public boolean isFinished() {
        return true;
    }
}
