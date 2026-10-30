package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("frontLeft");
        c.frontRightName.set("frontRight");
        c.backLeftName.set("backLeft");
        c.backRightName.set("backRight");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(-3.25);
        c.yPodOffset.set(-5.575);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.447550849756132);
                Controller secondaryTranslationalForward = Controller.proportional(0.16535808020593729);
                Controller primaryTranslationalLateral = Controller.proportional(0.7314420052902664);
                Controller secondaryTranslationalLateral = Controller.proportional(0.270248276464416);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.01290669593072527));
                c.brake.set(Controller.proportionalFeedforward(0.01097069154111648));

                c.headingFeedback.set(Controller.proportional(8.3092342003266));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.069942183148222, 0.011777511946786787));

                c.linearBrakeCoefficients.set(Matrix.diag(0.012793626412197622, 0.01484014803678948));
                c.quadraticBrakeCoefficients.set(Matrix.diag(7.565201507080759E-6, -2.684111386297694E-5));

                c.maxAchievableForwardVelocity.set(59.20429907870304);
                c.maxAchievableStrafeVelocity.set(47.31481056648906);
                c.naturalForwardDeceleration.set(17.16706335662614);
                c.naturalStrafeDeceleration.set(22.854800187783116);
            }
    );



//    public static Follower create(HardwareMap h){
////      Add other tuning data to use follower properly
//        return new Follower(
//                new PinpointLocalizer(h),
//                new Mecanum(h,drivetrainConfig),
//                new Foresight()
//
//        );
//    }
    public static Follower create(HardwareMap h) {
        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }
}