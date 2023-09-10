package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.TriggerReader;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.common.commands.drivetraincommands.DrivetrainCommand;
import org.firstinspires.ftc.teamcode.common.commands.intakecommands.StartIntakeCommand;
import org.firstinspires.ftc.teamcode.common.commands.intakecommands.StopIntakeCommand;
import org.firstinspires.ftc.teamcode.common.commands.liftcommands.LiftCommand;
import org.firstinspires.ftc.teamcode.common.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.common.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.common.subsystems.LiftSubsystem;

import java.util.List;

@TeleOp(name = "\uD83D\uDE22")
public class Teleop extends CommandOpMode {

    Motor liftMotor;
    TriggerReader liftTriggerReader;

    @Override
    public void initialize() {
        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
        MotorEx frontLeft = new MotorEx(hardwareMap, "MotorFrontLeft", Motor.GoBILDA.RPM_435);
        MotorEx frontRight = new MotorEx(hardwareMap, "MotorFrontRight", Motor.GoBILDA.RPM_435);
        MotorEx backLeft = new MotorEx(hardwareMap, "MotorBackLeft", Motor.GoBILDA.RPM_435);
        MotorEx backRight = new MotorEx(hardwareMap, "MotorBackRight", Motor.GoBILDA.RPM_435);
        DriveSubsystem drive = new DriveSubsystem(frontLeft, frontRight, backLeft, backRight);

        Motor intakeMotor = new Motor(hardwareMap, "intake", Motor.GoBILDA.BARE);
        IntakeSubsystem intake = new IntakeSubsystem(intakeMotor);
        StartIntakeCommand startIntake = new StartIntakeCommand(intake);
        StopIntakeCommand stopIntake = new StopIntakeCommand(intake);

        liftMotor.setRunMode(Motor.RunMode.RawPower);
        LiftSubsystem lift = new LiftSubsystem(liftMotor);
        liftMotor = new Motor(hardwareMap, "lift", Motor.GoBILDA.BARE);


        GamepadEx driverOp = new GamepadEx(gamepad1);
        GamepadEx toolsOp = new GamepadEx(gamepad2);
        liftTriggerReader = new TriggerReader(toolsOp, GamepadKeys.Trigger.RIGHT_TRIGGER);
        LiftCommand liftCommand = new LiftCommand(lift,
                () -> toolsOp.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER));
        lift.setDefaultCommand(liftCommand);
        Button intakeButton = new GamepadButton(toolsOp, GamepadKeys.Button.A);

        intakeButton.toggleWhenPressed(startIntake, stopIntake);

        DrivetrainCommand drivetrainCommand = new DrivetrainCommand(drive, driverOp::getLeftY, driverOp::getLeftX, driverOp::getRightX);
        drive.setDefaultCommand(drivetrainCommand);
    }


}
