package CenterstageBOB;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Collector {
    private final LinearOpMode opMode;

    private DcMotorEx leftWheel = null;
    private DcMotorEx rightWheel = null;

    public Collector(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void collect() {
//        if (opMode.gamepad2.right_bumper) {
//            leftWheel.setPower(-1);
//            rightWheel.setPower(-1);
//        } else if (opMode.gamepad2.left_bumper) {
//            leftWheel.setPower(1);
//            rightWheel.setPower(1);
//        } else {
//            leftWheel.setPower(0);
//            rightWheel.setPower(0);
//        }

        if (opMode.gamepad2.right_trigger > 0.1) {
            leftWheel.setPower(-opMode.gamepad2.right_trigger);
            rightWheel.setPower(-opMode.gamepad2.right_trigger);
        } else if (opMode.gamepad2.left_trigger > 0.1) {
            leftWheel.setPower(opMode.gamepad2.left_trigger);
            rightWheel.setPower(opMode.gamepad2.left_trigger);
        } else {
            leftWheel.setPower(0);
            rightWheel.setPower(0);
        }
    }

    public void init() {
        leftWheel = opMode.hardwareMap.get(DcMotorEx.class, "leftWheel");
        rightWheel = opMode.hardwareMap.get(DcMotorEx.class, "rightWheel");

        rightWheel.setDirection(DcMotorEx.Direction.REVERSE);
    }
}
