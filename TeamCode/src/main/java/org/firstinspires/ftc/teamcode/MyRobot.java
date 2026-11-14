package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Mechanisms.IntakeMech;
import org.firstinspires.ftc.teamcode.Mechanisms.LauncherPT;
import org.firstinspires.ftc.teamcode.Mechanisms.SensorTest;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class MyRobot implements NextRobot {
//// Must initialize any mechanisms created in this class.
/// Don't touch anything in here its all done.
    public LauncherPT launcher = new LauncherPT();
    public IntakeMech intakeMech = new IntakeMech();
//    public SensorTest cdSensor = new SensorTest();
    public LauncherPT getLauncer(){
        return launcher;
    }

    @Override
    public Set<Mechanism> getMechanisms(){
        return Set.of(launcher,intakeMech);
    }
//// Go to IntakeOpmode.
}
