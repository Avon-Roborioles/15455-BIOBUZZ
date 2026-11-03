package org.firstinspires.ftc.teamcode.OpModes;

import static com.pedropathing.ivy.commands.Commands.instant;

import com.pedropathing.ivy.Scheduler;

import org.firstinspires.ftc.teamcode.Mechanisms.LauncherPT;
import org.firstinspires.ftc.teamcode.MyRobot;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.units.Units;

@NextTeleop(name = "LauncherOpMode")
public class LauncherOpMode extends NextOpMode {
    private final MyRobot robot;
    private double target = 100;
    private double kV = 0.0002;
    private double kP = 0;
    private double p = 0;
    private double v =0;
    private double t = 0;
    CommandGamepad gp1 = new CommandGamepad(gamepad1);

    public LauncherOpMode(MyRobot robot){
        super(robot);
        this.robot = robot;
    }

    @Override
    public void disabledPeriodic(){
//        gp1.dpadLeft().onTrue(instant(() -> {kV = v +0.0001; robot.launcher.increment(kV,kP);}));
        gp1.dpadRight().onTrue(instant(() -> {kP = p + 0.1; robot.launcher.increment(kV,kP);}));
        gp1.dpadUp().onTrue(instant(() -> {target = t + 100;}));
        gp1.dpadDown().onTrue(instant(() -> {target = t - 100;}));

    }
    @Override
    public void periodic() {
        gp1.b().onTrue(robot.launcher.setTargetVelo(target));
        gp1.a().onTrue(robot.launcher.onStop);
//        gp1.dpadUp().onTrue(instant(() -> target = 10000));
        robot.launcher.launchMotor.getVelocityConstants().withV(kV);
//        gp1.leftBumper().onTrue(robot.launcher.decrement());
//        gp1.dpadUp().onTrue(robot.launcher.positionTest());
        v = kV;
        p = kP;
        t = target;



//    @Override
//    public void periodic(){
//        Telemetry.log("Motor Velocity: ", robot.launcher.launchMotor.getEncoderVelocity());
//        Telemetry.log("Motor Velocity(rpm): ", robot.launcher.launchMotor.getEncoderVelocity().into(Units.RotationsPerMinute));
//        Telemetry.log("Attempt to calculate rpm with throttle: ", robot.launcher.launchMotor.getThrottle()*1580);
        Telemetry.log("Throttle: ", robot.launcher.launchMotor.getThrottle());
//        Telemetry.log("IDK what this is ", robot.launcher.launchMotor.getVelocityFF().calculate(1000));

        Telemetry.log("targetVelo: ", target);
        Telemetry.log("kV: ", kV);
        Telemetry.log("kP", kP);

        Telemetry.update();
    }
    @Override
    public void end(){
        Scheduler.reset();
    }



}
