package org.firstinspires.ftc.teamcode.OpModes;

import org.firstinspires.ftc.teamcode.MyRobot;

import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;

@NextTeleop
public class Launcher  extends NextOpMode {
    private final MyRobot robot;

    public Launcher(MyRobot robot){
        super(robot);
        this.robot = robot;
    }


}
