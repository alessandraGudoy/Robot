package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenixpro.hardware.TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class Talons extends SubsystemBase {

    private WPI_TalonFX frontLeft;
    private WPI_TalonFX backLeft;
    private WPI_TalonFX frontRight;
    private WPI_TalonFX backRight;

    private MotorControllerGroup left;
    private MotorControllerGroup right;

    private DifferentialDrive diffDrive;

    // CONSTRUCTOR - set up at the start (only called once)
    public Talons() {
        frontLeft = new WPI_TalonFX(1);
        backLeft = new WPI_TalonFX(2);
        frontRight = new WPI_TalonFX(4);
        backRight = new WPI_TalonFX(3);

        //left = new MotorControllerGroup(frontLeft, backLeft);
        //right = new MotorControllerGroup(frontRight, backRight);

        //diffDrive = new DifferentialDrive(left, right);
    }

    // METHODS (set speed, get values of sensors/encoders, etc.)
    public void tank(double speed1, double speed2) {
        //diffDrive.tankDrive(speed1, speed2);
        frontLeft.set(speed1);
        backLeft.set(speed1);
        frontRight.set(speed2);
        backRight.set(speed2);
    }

    // PERIODIC - runs repeatedly (like periodic from timed robot)
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Output", frontLeft.getMotorOutputPercent());
    }
}
