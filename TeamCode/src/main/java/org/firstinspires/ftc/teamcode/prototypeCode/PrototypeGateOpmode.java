package org.firstinspires.ftc.teamcode.prototypeCode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class PrototypeGateOpmode extends OpMode {
    public DistanceSensor laserSensor;
    public Servo testServo;
    public void init() {
        laserSensor = hardwareMap.get(DistanceSensor.class, "laserSensor");
        testServo = hardwareMap.get(Servo.class, "testServo");

    }

    private boolean sensorActivation(){
        if(laserSensor.getDistance(DistanceUnit.CM) > 0){
            return true;
        }
        return false;
    }

    private void runServo(){
        if(sensorActivation()){
            testServo.setPosition(0.5);
        }
    }
    public void loop(){
        runServo();
        telemetry.addData("Laser Sensor", laserSensor.getDistance(DistanceUnit.CM));
        telemetry.addData("Servo Pos: ", testServo.getPosition());
        telemetry.update();

    }
}
