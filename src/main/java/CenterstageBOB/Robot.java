package CenterstageBOB;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Robot {
    private LinearOpMode opMode;
    private Gamepad currentGamepad1;
    private Gamepad previousGamepad1;

    public Drivetrain drivetrain;
    public Collector collector;

    public Robot(LinearOpMode opMode, Gamepad currentGamepad1, Gamepad previousGamepad1) {
        this.opMode = opMode;
        this.currentGamepad1 = currentGamepad1;
        this.previousGamepad1 = previousGamepad1;
    }

    public void init() {
        drivetrain = new Drivetrain(opMode, currentGamepad1, previousGamepad1);
        collector = new Collector(opMode);
    }

}
