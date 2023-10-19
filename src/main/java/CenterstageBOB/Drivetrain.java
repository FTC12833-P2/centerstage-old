package CenterstageBOB;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Drivetrain {
    private final LinearOpMode opMode;

    private DcMotorEx flMotor = null;
    private DcMotorEx frMotor = null;
    private DcMotorEx blMotor = null;
    private DcMotorEx brMotor = null;

    public AprilTags aprilTags;

    private Gamepad currentGamepad1;
    private Gamepad previousGamepad1;
    boolean isSlow = false;

    public Drivetrain(LinearOpMode opMode, Gamepad currentGamepad1, Gamepad previousGamepad1) {
        this.opMode = opMode;
        this.currentGamepad1 = currentGamepad1;
        this.previousGamepad1 = previousGamepad1;
        init();
    }

    public void driveWithSticks() {
        double drivePower = -opMode.gamepad1.left_stick_y;
        double strafePower = opMode.gamepad1.left_stick_x;
        double rotatePower = opMode.gamepad1.right_stick_x;

        double FLPower = drivePower + strafePower + rotatePower;
        double FRPower = drivePower - strafePower - rotatePower;
        double BLPower = drivePower - strafePower + rotatePower;
        double BRPower = drivePower + strafePower - rotatePower;

        if (currentGamepad1.a && !previousGamepad1.a) {
            isSlow = !isSlow;
        }

        double maxMotorPwr = Math.max(Math.max(Math.abs(FLPower), Math.abs(FRPower)),
                Math.max(Math.abs(BLPower), Math.abs(BRPower)));

        if (maxMotorPwr > 1) {
            FLPower /= maxMotorPwr;
            FRPower /= maxMotorPwr;
            BLPower /= maxMotorPwr;
            BRPower /= maxMotorPwr;
        }

        if (isSlow) {
            FLPower *= 0.5;
            FRPower *= 0.5;
            BLPower *= 0.5;
            BRPower *= 0.5;
        }

        flMotor.setPower(FLPower * 0.7);
        frMotor.setPower(FRPower * 0.7);
        blMotor.setPower(BLPower * 0.7);
        brMotor.setPower(BRPower * 0.7);

        previousGamepad1.copy(currentGamepad1);
        currentGamepad1.copy(opMode.gamepad1);
    }

    public void init(){
        flMotor = opMode.hardwareMap.get(DcMotorEx.class, "flMotor");
        frMotor = opMode.hardwareMap.get(DcMotorEx.class, "frMotor");
        blMotor = opMode.hardwareMap.get(DcMotorEx.class, "blMotor");
        brMotor = opMode.hardwareMap.get(DcMotorEx.class, "brMotor");

        flMotor.setDirection(DcMotorEx.Direction.REVERSE);
        blMotor.setDirection(DcMotorEx.Direction.REVERSE);

        aprilTags = new AprilTags(opMode);
    }
}

