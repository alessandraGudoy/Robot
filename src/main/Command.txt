package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class COMMAND_NAME extends CommandBase {

    // Declare subsystem
        // private SUBSYSTEM_NAME subsystem;
        // private double speed;

    // CONSTRUCTOR - only runs once (when robot starts)
    public COMMAND_NAME(/*SUBSYTEM_NAME subs, double newSpeed */) {
        // subsystem = subs;
        // speed = newSpeed;
        // addRuirements(susbsytem name);   // tells command it uses the subsystem
                                            // all commands using same subsystem should 
                                            // be stopped before running this command
    }

    // runs every time command starts
    @Override
    public void initialize() {
        // stuff robot should do before running command
    }

    @Override
    public void execute() {
        // action of robot
        // when command is running, this execute method runs repeatedly
    }

    @Override
    public void end(boolean interrupted) {
        // stuff robot should do when command ends
    }

    @Override
    public boolean isFinished() {
        // tells when command is finished so next command can run
    }

}