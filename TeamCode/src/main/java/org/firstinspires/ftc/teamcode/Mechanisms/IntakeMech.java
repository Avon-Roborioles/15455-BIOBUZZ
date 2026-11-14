package org.firstinspires.ftc.teamcode.Mechanisms;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.opmode.NextTeleop;


public class IntakeMech implements Mechanism {
    private NextMotor intakeMotor;
    private NextServo liftServo;

    public IntakeMech(){
        intakeMotor = new NextMotor("intakeMotor");
        liftServo = new NextServo("liftServo");

        intakeMotor.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.FLOAT);
        liftServo.setPosition(0);

//// Initializes both the motors and servo on the intake. Set position may need to be done in a start function and not a constructor
    }

    public NextMotor getIntakeMotor(){return intakeMotor;}
    public NextServo getLiftServo(){return liftServo;}
////  functions needed to access the motor and servo variables at the start.

    public Command setThrottle(double throttle){return instant(() -> getIntakeMotor().setThrottle(throttle));}
    public Command setPosition(double position){return instant(() -> getLiftServo().setPosition(position));}

//// Commands tell the parts what to do.
//// Go to MyRobot class next.
}
