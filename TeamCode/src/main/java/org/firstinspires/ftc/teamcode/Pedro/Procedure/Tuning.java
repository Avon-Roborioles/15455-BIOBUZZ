package org.firstinspires.ftc.teamcode.Pedro.Procedure;


import com.pedropathing.tuning.autotune.Procedure;
import com.pedropathing.tuning.autotune.Tuner;

import org.firstinspires.ftc.teamcode.Pedro.Procedure.MecanumTuner;

public class Tuning {
    @Tuner
    public static Procedure mecanumTuner() {
        return new MecanumTuner();
    }
    
}