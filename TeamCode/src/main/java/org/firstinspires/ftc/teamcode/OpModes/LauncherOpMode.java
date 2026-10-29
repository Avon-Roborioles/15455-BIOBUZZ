package org.firstinspires.ftc.teamcode.OpModes;

import org.firstinspires.ftc.teamcode.MyRobot;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "LauncherOpMode")
public class LauncherOpMode extends NextOpMode {
    private MyRobot LNR;
    CommandGamepad gp1 = new CommandGamepad(gamepad1);

    public LauncherOpMode(MyRobot LNR){
        super(LNR);
    }

    @Override
    public void periodic(){
        gp1.circle().whileTrue(LNR.launcher.onRun);
        gp1.a().onTrue(LNR.launcher.onStop);



        Telemetry.log("Motor Velocity: ", LNR.launcher.launchMotor.getEncoderVelocity());
        Telemetry.update();
    }



}
