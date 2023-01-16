package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SingleMotor;

public class Stop extends CommandBase{

    private SingleMotor motorSubsystem;

    // CONSTRUCTOR
    public Stop(SingleMotor subs){
        motorSubsystem = subs;
        addRequirements(subs);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        motorSubsystem.setStop();
    }

    @Override
    public void end(boolean interrupted){
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}