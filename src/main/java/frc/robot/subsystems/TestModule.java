package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SwerveModuleConsts;

public class TestModule extends SubsystemBase {

    private CANSparkMax turnMotor;
    private CANSparkMax driveMotor;

    private RelativeEncoder turnEnc;
    private RelativeEncoder driveEnc;
    private AnalogEncoder absoluteEncoder;

    /* *** CAN ENC *** */
    private SparkMaxAbsoluteEncoder testEnc;

    private PIDController pid;
    private double dEncoderOffset;

    // CONSTRUCTOR - set up at the start (only called once)
    public TestModule(int dMotorId, int tMotorId/* , int absEncPortr, double encOffset*/) {
        turnMotor = new CANSparkMax(dMotorId, MotorType.kBrushless);
        driveMotor = new CANSparkMax(tMotorId, MotorType.kBrushless);

        turnEnc = turnMotor.getEncoder();
        driveEnc = driveMotor.getEncoder();

        //testEnc = new SparkMaxAbsoluteEncoder(turnMotor, );

        pid = new PIDController(0, 0, 0);
        pid.enableContinuousInput(-Math.PI, Math.PI);

        //dEncoderOffset = encOffset;

        resetEncoders();
    }

    public double getDriveEnc(){
        return driveEnc.getPosition();
    }

    /* *************** GETTING ABSOLUTE ENCODER *************** */
    public double getAbsEnc(){
        return absoluteEncoder.getAbsolutePosition() * 2 * Math.PI - dEncoderOffset;
    }

    public double getTurnEnc(){
        return turnEnc.getPosition();
    }

    public double getDriveSpeed(){
        return driveEnc.getVelocity();
    }

    public double getTurnSpeed(){
        return turnEnc.getVelocity();
    }

    public void resetEncoders(){
        driveEnc.setPosition(0);
        turnEnc.setPosition(0);
        //turnEnc.setPosition(getAbsEnc());
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
