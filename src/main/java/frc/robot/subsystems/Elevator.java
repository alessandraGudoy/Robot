package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConsts;

public class Elevator extends SubsystemBase {

    // PHYSICAL COMPONENTS OF ROBOT (motors, encoders, etc.)
    private CANSparkMax motor1 = new CANSparkMax(DriveConsts.frontLeftPort, MotorType.kBrushless);
    private CANSparkMax motor2 = new CANSparkMax(DriveConsts.backLeftPort, MotorType.kBrushless);

    private RelativeEncoder enc;

    // CONSTRUCTOR - set up at the start (only called once)
    public Elevator() {
        enc = motor1.getEncoder();
    }

    // METHODS (set speed, get values of sensors/encoders, etc.)
    public void goUp(double speed) {
        motor1.set(speed);
        motor2.set(speed);
    }

    public void goDown(double speed) {
        motor1.set(-speed);
        motor2.set(-speed);
    }

    public void stop() {
        motor1.set(0);
        motor2.set(0);
    }

    public double getEnc(){
        return enc.getPosition();
    }

    public void resetEnc(){
        enc.setPosition(0);
    }

    // PERIODIC - runs repeatedly (like periodic from timed robot)
    @Override
    public void periodic() {
    }
}
