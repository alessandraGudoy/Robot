package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class Arcade extends CommandBase{

    private Drive driveSubsystem;
    private DoubleSupplier xSpeed;
    private DoubleSupplier ySpeed;

    // CONSTRUCTOR
    public Arcade(Drive subs, DoubleSupplier xSpeed, DoubleSupplier ySpeed){
        driveSubsystem = subs;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        addRequirements(subs);
    }

    @Override
    public void initialize(){
        driveSubsystem.setSpeed(0, 0);
    }

    @Override
    public void execute(){
        SmartDashboard.putString("Drive", "ARCDADE");
        //driveSubsystem.setSpeed(-ySpeed.getAsDouble() + xSpeed.getAsDouble(), -ySpeed.getAsDouble() - ySpeed.getAsDouble());
        driveSubsystem.arc(-xSpeed.getAsDouble(), -ySpeed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted){
        driveSubsystem.setSpeed(0, 0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}