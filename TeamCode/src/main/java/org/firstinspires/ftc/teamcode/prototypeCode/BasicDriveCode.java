package org.firstinspires.ftc.teamcode.prototypeCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.Pedro.Procedure.Constants;

@TeleOp
public class BasicDriveCode extends OpMode{
    private Follower follower;


    @Override
    public void init(){
        follower = Constants.create(hardwareMap);
    }

    @Override
    public void loop(){
        follower.manual(
                -gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_y
        );
        follower.update();

    }

}
