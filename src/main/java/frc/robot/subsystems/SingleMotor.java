package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConsts;
import frc.robot.Constants.SingleMotorConsts;

public class SingleMotor extends SubsystemBase {
    private CANSparkMax motor = new CANSparkMax(DriveConsts.backLeftPort, MotorType.kBrushless);
    private CANSparkMax motor2 = new CANSparkMax(DriveConsts.frontLeftPort, MotorType.kBrushless);

    public SingleMotor() {}

    public void setForward(double speed){
        motor.set(speed);
        motor2.set(speed);
    }

    public void setBackward(double speed){
        motor.set(-speed);
        motor2.set(-speed);
    }

    public void setStop(){
        motor.set(0);
        motor2.set(0);
    }

    @Override
    public void periodic() {
    }
}
