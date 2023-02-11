package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConsts;

public class Drive extends SubsystemBase {
    private CANSparkMax frontLeft = new CANSparkMax(DriveConsts.frontLeftPort, MotorType.kBrushless);
    private CANSparkMax backLeft = new CANSparkMax(DriveConsts.backLeftPort, MotorType.kBrushless);
    private CANSparkMax frontRight = new CANSparkMax(DriveConsts.frontRightPort, MotorType.kBrushless);
    private CANSparkMax backRight = new CANSparkMax(DriveConsts.backRightPort, MotorType.kBrushless);

    private MotorControllerGroup left, right; private DifferentialDrive diffDrive;

    public Drive() {
        left = new MotorControllerGroup(frontLeft, backLeft);
        right = new MotorControllerGroup(frontRight, backRight);
        diffDrive = new DifferentialDrive(left, right);
    }

    public void setSpeed(double lSpeed, double rSpeed) {
        left.set(lSpeed);
        right.set(rSpeed);
    }

    public void arc(double lSpeed, double rSpeed){
        diffDrive.arcadeDrive(lSpeed, rSpeed);
    }

    public void tank(double lSpeed, double rSpeed){
        diffDrive.tankDrive(lSpeed, rSpeed);
    }

    @Override
    public void periodic() {
        // similar to robot periodic
        // runs repeatedly (regardless of mode (auto/tele))
        SmartDashboard.putNumber("Speed", frontLeft.get());
    }

}
