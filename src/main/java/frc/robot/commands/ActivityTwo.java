package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ActivityTwo extends CommandBase {

    private Elevator elevator;
    private double speed;
    private int iCounter = 0;
    public ActivityTwo(Elevator subs, double newSpeed) {
         elevator = subs;
         speed = newSpeed;
         addRequirements(subs);
    }

    // runs every time command starts
    @Override
    public void initialize() {
        SmartDashboard.putString("ELEVATOR", "STARTING");
        elevator.resetEnc();
    }

    @Override
    public void execute() {
        double enc = elevator.getEnc();
        SmartDashboard.putNumber("Elevator Case", iCounter);
        SmartDashboard.putString("ELEVATOR", "EXECUTING");
        SmartDashboard.putNumber("ENCODER", iCounter);
        switch(iCounter){
            case 0:
                if(enc<50){

                }
            break;
            case 1:

            break;
            case 2:

            break;
            case 3:

            break;
        }
    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putString("ELEVATOR", "FINISHED");
    }

    @Override
    public boolean isFinished() {
        return iCounter>3;
    }

}