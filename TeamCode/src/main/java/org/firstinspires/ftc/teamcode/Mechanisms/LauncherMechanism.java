package org.firstinspires.ftc.teamcode.Mechanisms;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class LauncherMechanism implements Mechanism {
    private NextMotor launcherMotor;

    public LauncherMechanism(){
        launcherMotor = new NextMotor("launcher");
    }

    public Command launch() {
        return infinite(() -> launcherMotor.setThrottle(1));
    }


}
