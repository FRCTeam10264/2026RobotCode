// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.math.MathUtil;
import frc.robot.Constants.OIConstant;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.Constants;
import frc.robot.commands.DriveCommand;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Index m_index = new Index();
  private final shooterwheelB m_bshooterH = new shooterwheelB();
  private final intakerollers m_intake = new intakerollers();
  private final flywheel m_Flywheel = new flywheel();
  private final Intakepivot m_Intakepivot = new Intakepivot();
  private final endgame m_endgame = new endgame();
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();



  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final  CommandXboxController m_CoDriverController = new CommandXboxController(1);
  private final  CommandXboxController m_DriverController = new CommandXboxController(0);




  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
  

  
    m_DriverController.a().whileTrue(new ShootH(m_index));
    m_DriverController.rightTrigger().whileTrue(new shooterH(m_bshooterH));
    m_DriverController.leftBumper().whileTrue(new IntakeN(m_intake));
    m_DriverController.leftTrigger().toggleOnTrue(new IntakepivotN(m_Intakepivot));
    m_DriverController.leftTrigger().toggleOnTrue(new pivotdown(m_Intakepivot));
    m_DriverController.rightTrigger().whileTrue(new flywheelH(m_Flywheel));
    m_CoDriverController.y().whileTrue(new endgameT(m_endgame));
    m_CoDriverController.a().whileTrue(new endgameout(m_endgame));

    m_DriverController.leftStick().whileTrue(m_robotDrive.setXComand());


  // Turning is controlled by the X axis of the right stick.
        new RunCommand(
            () ->
                m_robotDrive.drive(
                    -MathUtil.applyDeadband(
                        m_DriverController.getLeftY(), OIConstant.kDriveDeadband),
                    -MathUtil.applyDeadband(
                        m_DriverController.getLeftX(), OIConstant.kDriveDeadband),
                    -MathUtil.applyDeadband(
                        m_DriverController.getRightX(), OIConstant.kDriveDeadband),
                    true),
            m_robotDrive).withName("Robot Drive Default");
    

    m_CoDriverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}

           








