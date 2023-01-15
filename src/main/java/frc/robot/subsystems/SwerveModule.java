package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.AnalogInput;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SwerveModuleConsts;

public class SwerveModule extends SubsystemBase {

    private CANSparkMax turnMotor;
    private WPI_TalonFX driveMotor;

    private RelativeEncoder turnEnc;
    private TalonFXSensorCollection driveEnc;
    private AnalogEncoder absoluteEncoder;

    private PIDController pid;
    private double dEncoderOffset;

    // CONSTRUCTOR - set up at the start (only called once)
    public SwerveModule(int dMotorId, int tMotorId, int absEncPort, double encOffset) {
        turnMotor = new CANSparkMax(dMotorId, MotorType.kBrushless);
        driveMotor = new WPI_TalonFX(tMotorId);

        turnEnc = turnMotor.getEncoder();
        driveEnc = new TalonFXSensorCollection(driveMotor);

        absoluteEncoder = new AnalogEncoder(absEncPort);

        pid = new PIDController(0, 0, 0);
        pid.enableContinuousInput(-Math.PI, Math.PI);

        dEncoderOffset = encOffset;

        resetEncoders();
    }

    public double getDriveEnc(){
        return driveEnc.getIntegratedSensorPosition();
    }

    /* *************** GETTING ABSOLUTE ENCODER *************** */
    public double getAbsEnc(){
        return absoluteEncoder.getAbsolutePosition() * 2 * Math.PI - dEncoderOffset;
    }

    public double getTurnEnc(){
        return turnEnc.getPosition();
    }

    public double getDriveSpeed(){
        return driveEnc.getIntegratedSensorVelocity();
    }

    public double getTurnSpeed(){
        return turnEnc.getVelocity();
    }

    public void resetEncoders(){
        driveEnc.setIntegratedSensorPosition(0, 0);
        turnEnc.setPosition(getAbsEnc());
    }

    public SwerveModuleState getState(){
        return new SwerveModuleState(getDriveSpeed(), new Rotation2d(getTurnEnc()));
    }

    public void setDesiredState(SwerveModuleState state){
        state = SwerveModuleState.optimize(state, getState().angle);
        driveMotor.set(state.speedMetersPerSecond / SwerveModuleConsts.maxDriveSpeed);
        turnMotor.set(pid.calculate(getTurnEnc(), state.angle.getRadians()));
        SmartDashboard.putString("Swerve State", state.toString());
    }

    public void stop(){
        driveMotor.set(0);
        turnMotor.set(0);
    }
    

    // PERIODIC - runs repeatedly (like periodic from timed robot)
    @Override
    public void periodic() {
    }
}
