package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConsts;
import frc.robot.subsystems.Drive;

public class DriveBackward extends CommandBase{

    private Drive driveSubsystem;

    // CONSTRUCTOR
    public DriveBackward(Drive subs){
        driveSubsystem = subs;
        addRequirements(subs);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        driveSubsystem.setSpeed(DriveConsts.leftSpeed, DriveConsts.rightSpeed);
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