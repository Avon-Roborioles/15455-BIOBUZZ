package org.firstinspires.ftc.teamcode.prototypeCode;

import com.pedropathing.controllers.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.robocol.Command;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.HoldVelocity;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.RunToVelocity;


@TeleOp
public class PrototypeLauncherOpmode extends OpMode {
    private MotorEx motor = new MotorEx("LaunchMotor");
    private PIDController controller  = new PIDController(0.005,0,0);
    private double targetRPM;


    public Command toTargetRPM(){
        return new RunToVelocity(motor, targetRPM, controller, this);
    }
    public Command holdTargetRPM(){
        return new HoldVelocity(motor, controller, this);
    }


    public void init(){


    }

    public void loop() {

    }
}
