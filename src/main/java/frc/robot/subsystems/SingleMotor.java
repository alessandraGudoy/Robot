package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SingleMotorConsts;

public class SingleMotor extends SubsystemBase {
    private CANSparkMax motor = new CANSparkMax(SingleMotorConsts.port, MotorType.kBrushless);

    public SingleMotor() {}

    public void setForward(double speed){
        motor.set(speed);
    }

    public void setBackward(double speed){
        motor.set(speed);
    }

    public void setStop(){
        motor.set(0);
    }

    public void setSpeed(double speed){
        motor.set(speed);
    }

    @Override
    public void periodic() {
    }
}
