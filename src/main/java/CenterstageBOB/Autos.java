package CenterstageBOB;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Auto BOB", group = "mm")

public class Autos extends LinearOpMode {

    public Gamepad currentGamepad1 = new Gamepad();
    public Gamepad previousGamepad1 = new Gamepad();
    public Robot robot = new Robot(this, currentGamepad1, previousGamepad1);
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initializing... Please Wait");
        telemetry.update();
        robot.init();
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        robot.drivetrain.driveToAprilTag();

        robot.drivetrain.aprilTags.visionPortal.close();
    }
}
