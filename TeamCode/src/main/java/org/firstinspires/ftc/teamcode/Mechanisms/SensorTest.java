package org.firstinspires.ftc.teamcode.Mechanisms;

import dev.nextftc.hardware.sensors.NextColorDistanceSensor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;

public class SensorTest implements Mechanism {
    NextColorDistanceSensor cSensor;

    public SensorTest(){
        cSensor = new NextColorDistanceSensor("colorSensor");

    }

    @Override
    public void periodic(){
        cSensor.update();
        Telemetry.log(cSensor.debug());
        Telemetry.update();
    }

}
