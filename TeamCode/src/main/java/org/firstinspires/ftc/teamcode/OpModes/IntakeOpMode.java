package org.firstinspires.ftc.teamcode.OpModes;

import org.firstinspires.ftc.teamcode.MyRobot;

import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;

@NextTeleop
public class IntakeOpMode extends NextOpMode {
    private MyRobot robot;
    //// I forgot to finish this yesterday so you guys should just make this opMode
    //// I also have the control hub with me so you unfortunately cannot test your code
    //// all you guys need to do is initialize the intake objects, create a start function and create a periodic function
    //// If you need help go to this site: https://kdoc.nextftc.dev/robot/dev.nextftc.robot/-mechanism/index.html
    //// or talk to Mr James. Do not use AI the point is to learn how to do this
    //// once you create the basics of this class you can go back to the mechanisms class and add a way to control the throttle, if you get to this point and are stuck you should ask Mr. James for help
    //// Tuesday we'll go over what you guys did.
    public IntakeOpMode(MyRobot robot){
        super(robot);
        this.robot = robot;
//// Initializes the myRobot class to access the mechanisms and commands in them
    }

    @Override
    public void start(){
//// runs when the start button on the driver hub is pressed
    }

    @Override
    public void periodic(){
//// runs continuously
    }
}
