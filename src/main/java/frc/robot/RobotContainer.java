package frc.robot;

import frc.robot.Constants.DriveConsts;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.SingleMotorConsts;
import frc.robot.commands.ActivityOne;
import frc.robot.commands.ActivityTwo;
import frc.robot.commands.Arcade;
import frc.robot.commands.Tank;

import java.lang.ModuleLayer.Controller;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.SingleMotor;
import frc.robot.subsystems.Sparks;
import frc.robot.subsystems.Talons;

public class RobotContainer {
    //private final SingleMotor m_SingleMotor = new SingleMotor();
    private final Drive m_drive = new Drive();
    //private final Elevator m_elevator = new Elevator();
    //private final Sparks m_drive = new Sparks();

    private final XboxController controller = new XboxController(OperatorConstants.rightStickPort);

    public RobotContainer() {
        m_drive.setDefaultCommand(new Tank(m_drive, () -> controller.getLeftY(), () -> -controller.getRightY()));

        configureBindings();
    }

    private void configureBindings() {
        //new JoystickButton(controller, 1).onTrue(new InstantCommand(() -> m_drive.resetEnc()));
        //new JoystickButton(controller, 2).onTrue(new ActivityTwo(m_elevator, 0.5));
        //new JoystickButton(controller, 5).whileTrue(new Arcade(m_drive, () -> controller.getLeftY(), () -> controller.getRightX()));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
