package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.SingleMotorConsts;
import frc.robot.subsystems.SingleMotor;

public class ActivityOne extends CommandBase{

    private SingleMotor motorSubsystem;
    private Timer timer;
    private int iStep = 0;

    // CONSTRUCTOR
    public ActivityOne(SingleMotor subs, double newSpeed){
        motorSubsystem = subs;
        timer = new Timer();
        addRequirements(subs);
    }

    @Override
    public void initialize(){
        iStep = 0;
        SmartDashboard.putString("State", "Starting");
    }

    @Override
    public void execute(){
        SmartDashboard.putString("State", "Executing");
        SmartDashboard.putNumber("STEP", iStep);

        switch(iStep){
            case 0:
                timer.reset();
                timer.start();
                iStep++;
                break;
            case 1:
                if(timer.get()<=5){
                    motorSubsystem.setForward(SingleMotorConsts.speed);
                } else{
                    iStep++;
                }
                break;
            case 2:
                motorSubsystem.setStop();
                iStep++;
                break;
        }

    }

    @Override
    public void end(boolean interrupted){
        motorSubsystem.setStop();
        iStep = 0;
        timer.stop();
        SmartDashboard.putString("State", "Ending");
    }

    @Override
    public boolean isFinished(){
        return iStep>2;
    }

}