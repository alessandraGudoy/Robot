package frc.robot;

import frc.robot.Constants.DriveConsts;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.SingleMotorConsts;
import frc.robot.commands.ActivityOne;
import frc.robot.commands.Arcade;
import frc.robot.commands.Tank;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.SingleMotor;

public class RobotContainer {
    private final SingleMotor m_SingleMotor = new SingleMotor();
    private final Drive m_drive = new Drive();

    private final XboxController controller = new XboxController(OperatorConstants.rightStickPort);

    public RobotContainer() {
        //m_drive.setDefaultCommand(new Tank(m_drive, () -> controller.getLeftY(), () -> controller.getRightY()));

        configureBindings();
    }

    private void configureBindings() {
        new JoystickButton(controller, 1).onTrue(new ActivityOne(m_SingleMotor, 0.2));
        //new JoystickButton(controller, 5).whileTrue(new Arcade(m_drive, () -> controller.getLeftY(), () -> controller.getRightX()));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
