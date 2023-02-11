package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConsts;
import frc.robot.subsystems.Drive;

public class DriveForward extends CommandBase{

    private Drive driveSubsystem;

    // CONSTRUCTOR
    public DriveForward(Drive subs){
        driveSubsystem = subs;
        addRequirements(subs);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){ 
        SmartDashboard.putString("Driving: ", "FORWARD");
        driveSubsystem.setSpeed(2, 2);
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