package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Mechanisms.LauncherPT;
import org.firstinspires.ftc.teamcode.Mechanisms.SensorTest;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class MyRobot implements NextRobot {
    public LauncherPT launcher = new LauncherPT();
    public SensorTest cdSensor = new SensorTest();

    @Override
    public Set<Mechanism> getMechanisms(){
        return Set.of(launcher,cdSensor);
    }
}
