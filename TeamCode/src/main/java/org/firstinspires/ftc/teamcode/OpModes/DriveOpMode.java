package org.firstinspires.ftc.teamcode.OpModes;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.MyRobot;

import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;

@NextTeleop @Disabled
public class DriveOpMode extends NextOpMode {
    private Follower follower;
    public final MyRobot robot;

    public DriveOpMode(MyRobot robot){
        super(robot);
        this.robot = robot;
    }

//    @Override
//    public void disabledPeriodic(){
////        follower = Constants.create(hardwareMap);
//    }
//
//
//    @Override
//    public void periodic(){
//        double forward = -gamepad1.left_stick_y;
//        double lateral = gamepad1.left_stick_x;
//        double turn = gamepad1.right_stick_x;
//
////        follower.manual(forward,lateral,turn);
////        follower.update();
//    }
}
