package org.firstinspires.ftc.teamcode.Mechanisms;

import static com.pedropathing.ivy.behaviors.InterruptedBehavior.END;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;

public class LauncherPT implements Mechanism {
    public NextMotor launchMotor;
    private double throttle = 1;

    public LauncherPT(){
        launchMotor = new NextMotor("launchMotor");
        launchMotor.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
        launchMotor.setDirection(NextMotor.Direction.REVERSE);
    }

    public Command onRun = Command.build()
            .setExecute(
                    ()-> launchMotor.setThrottle(throttle)
            )
            .requiring(launchMotor)
            .setPriority(1)
            .setInterruptedBehavior(END);

    public Command onStop = Command.build()
            .setStart(
                    () -> launchMotor.setThrottle(0)
            )
            .requiring(launchMotor)
            .setInterruptedBehavior(END)
            .setPriority(1);

}
