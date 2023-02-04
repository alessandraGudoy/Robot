package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class SUBSYSTEM_NAME extends SubsystemBase {

    // PHYSICAL COMPONENTS OF ROBOT (motors, encoders, etc.)
    private CANSparkMax frontLeft = new CANSparkMax(0, MotorType.kBrushless);

    // CONSTRUCTOR - set up at the start (only called once)
    public SUBSYSTEM_NAME() {

    }

    // METHODS (set speed, get values of sensors/encoders, etc.)
    public void setSpeed(double speed) {
        motor.set(speed);
    }

    // PERIODIC - runs repeatedly (like periodic from timed robot)
    @Override
    public void periodic() {
    }
}
