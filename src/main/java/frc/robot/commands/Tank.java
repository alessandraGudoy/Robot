package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Sparks;
import frc.robot.subsystems.Talons;

public class Tank extends CommandBase{

    private Drive driveSubsystem;
    //private Sparks driveSubsystem;
    private DoubleSupplier leftSpeed;
    private DoubleSupplier rightSpeed;

    // CONSTRUCTOR
    public Tank(Drive subs, DoubleSupplier lSpeed, DoubleSupplier rSpeed){
        driveSubsystem = subs;
        leftSpeed = lSpeed;
        rightSpeed = rSpeed;
        addRequirements(subs);
    }

    @Override
    public void initialize(){
        driveSubsystem.setSpeed(0, 0);
    }

    @Override
    public void execute(){
        SmartDashboard.putString("Drive", "TANK");
        SmartDashboard.putNumber("Left Stick", leftSpeed.getAsDouble());
        SmartDashboard.putNumber("Right Stick", rightSpeed.getAsDouble());
        driveSubsystem.setSpeed(leftSpeed.getAsDouble(), rightSpeed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted){
        driveSubsystem.setSpeed(0, 0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    public double modify(double num){
        num = Math.abs(num) > 0.1 ? num : 0;

        num = Math.cbrt(num);

        return num;
    }

}