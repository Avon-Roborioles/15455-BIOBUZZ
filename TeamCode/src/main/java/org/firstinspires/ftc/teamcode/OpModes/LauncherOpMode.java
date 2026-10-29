package org.firstinspires.ftc.teamcode.OpModes;

import org.firstinspires.ftc.teamcode.MyRobot;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "LauncherOpMode")
public class LauncherOpMode extends NextOpMode {
    private final MyRobot robot;
    CommandGamepad gp1 = new CommandGamepad(gamepad1);

    public LauncherOpMode(MyRobot robot){
        super(robot);
        this.robot = robot;
    }

    @Override
    public void periodic(){
        gp1.b().whileTrue(robot.launcher.onRun);
        gp1.a().onTrue(robot.launcher.onStop);



        Telemetry.log("Motor Velocity: ", robot.launcher.launchMotor.getEncoderVelocity());
        Telemetry.update();
    }



}
