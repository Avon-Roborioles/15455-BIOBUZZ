package org.firstinspires.ftc.teamcode.Mechanisms;

import static com.pedropathing.ivy.behaviors.InterruptedBehavior.END;

import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.robotcore.external.navigation.Rotation;
import org.opencv.core.Mat;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.units.Units;

public class LauncherPT implements Mechanism {
    public NextMotor launchMotor;
    private double throttle = 0.5;

    public LauncherPT(){
        launchMotor = new NextMotor("launchMotor");
        launchMotor.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
        launchMotor.setDirection(NextMotor.Direction.REVERSE);
        launchMotor.getPositionConstants().withP(0.01).withD(0.005);
        launchMotor.getVelocityConstants().withS(0.1);
//        launchMotor.getVelocityFF().getCoefficients().kV=0.001;
//        launchMotor.getVelocityFF().getCoefficients().kA=0;
//        launchMotor.getVelocityFF().getCoefficients().kS=0.01;

    }


    public Command setTargetVelo(double targetVelo) {
        return Command.build()
                .setExecute(
                        () -> launchMotor.setVelocitySetpoint(Units.getRotationsPerMinute(targetVelo))
                )
                .requiring(launchMotor)
                .setPriority(1)
                .setInterruptedBehavior(END);
    }

    public Command onStop =  Command.build()
                .setStart(
                        () -> launchMotor.setThrottle(0)
                )
                .requiring(launchMotor)
                .setInterruptedBehavior(END)
                .setPriority(1);



    public Command positionTest() {
        return instant(() -> {
            if(launchMotor.getEncoderPosition().getMagnitude()> 360){
                launchMotor.Companion.getMotorEventLoop().clear();
            }
            launchMotor.setPositionSetpoint(Units.Degrees.of(90));
        });
        }
    public Command positionIncrementTest() {return instant(() -> launchMotor.setPositionSetpoint(Units.Degrees.of(launchMotor.getEncoderPosition().getMagnitude()+10)));}

    public Command increment(double kS, double kP) {return instant(() -> launchMotor.getVelocityConstants().withV(kS).withP(kP));}
    public Command decrement() {return instant(() -> {throttle = launchMotor.getThrottle() - 0.05;launchMotor.setThrottle(throttle); });}
}
