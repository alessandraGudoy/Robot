package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class Sparks extends SubsystemBase {

    private CANSparkMax frontLeft;
    private RelativeEncoder enc;
    private CANSparkMax backLeft;
    private CANSparkMax frontRight;
    private CANSparkMax backRight;

    private MotorControllerGroup left;
    private MotorControllerGroup right;

    private DifferentialDrive diffDrive;

    // CONSTRUCTOR - set up at the start (only called once)
    public Sparks() {
        frontLeft = new CANSparkMax(5, MotorType.kBrushless);
        //backLeft = new CANSparkMax(6, MotorType.kBrushless);
        frontRight = new CANSparkMax(8, MotorType.kBrushless);
        backRight = new CANSparkMax(7, MotorType.kBrushless);

        //left = new MotorControllerGroup(frontLeft, backLeft);
        //right = new MotorControllerGroup(frontRight, backRight);

        //diffDrive = new DifferentialDrive(left, right);

        enc = frontLeft.getEncoder();
    }

    // METHODS (set speed, get values of sensors/encoders, etc.)
    public void tank(double speed1, double speed2) {
        //diffDrive.tankDrive(speed1, speed2);
        frontLeft.set(speed1);
        //backLeft.set(speed1);
        frontRight.set(speed2);
        backRight.set(speed2);
    }

    public void resetEnc(){
        enc.setPosition(0);
        
    }

    // PERIODIC - runs repeatedly (like periodic from timed robot)
    @Override
    public void periodic() {
        SmartDashboard.putNumber("COUNTS", enc.getPosition());
        SmartDashboard.putNumber("COUNTS", enc.getVelocity());
    }
}
