package CenterstageBOB;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;

public class Collector {
    private final LinearOpMode opMode;

    private CRServo leftWheel = null;
    private CRServo rightWheel = null;

    public Collector(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void collect() {
        if (opMode.gamepad2.right_bumper) {
            leftWheel.setPower(-1);
            rightWheel.setPower(-1);
        } else if (opMode.gamepad2.left_bumper) {
            leftWheel.setPower(1);
            rightWheel.setPower(1);
        } else {
            leftWheel.setPower(0);
            rightWheel.setPower(0);
        }
    }

    public void init() {
        leftWheel = opMode.hardwareMap.get(CRServo.class, "leftWheel");
        rightWheel = opMode.hardwareMap.get(CRServo.class, "rightWheel");

        rightWheel.setDirection(CRServo.Direction.REVERSE);
    }
}
