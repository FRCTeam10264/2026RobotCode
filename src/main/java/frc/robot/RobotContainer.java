// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
   private final Index m_index = new Index();
  private final Bshooterwheel m_bshooterHS = new Bshooterwheel();
  private final Bshooterwheel m_bshooterHL = new Bshooterwheel();
 


  private final intakerollers m_intake = new intakerollers();
  private final flywheel m_Flywheel = new flywheel();
  private final Intakepivot m_Intakepivot = new Intakepivot();
  private final endgame m_endgame = new endgame();

  // The driver's controller
  private final CommandXboxController m_driverController =
      new CommandXboxController(OIConstants.kDriverControllerPort);
     
      private final CommandXboxController m_CoDriverController =
      new CommandXboxController(OIConstants.kCoDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    // Configure default commands
    m_robotDrive.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
        new RunCommand(
            () ->
                m_robotDrive.drive(
                    -MathUtil.applyDeadband(
                        m_driverController.getLeftY(), OIConstants.kDriveDeadband),
                    -MathUtil.applyDeadband(
                        m_driverController.getLeftX(), OIConstants.kDriveDeadband),
                    -MathUtil.applyDeadband(
                        m_driverController.getRightX(), OIConstants.kDriveDeadband),
                    true),
            m_robotDrive).withName("Robot Drive Default"));

    

    SmartDashboard.putNumber("Bat Voltage", RobotController.getBatteryVoltage());

   

    
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
    // Left Stick Button -> Set swerve to X
    m_driverController.leftStick().whileTrue(m_robotDrive.setXCommand());
    m_driverController.start().onTrue(m_robotDrive.zeroHeadingCommand());

   m_driverController.rightBumper().whileTrue(new ShootH(m_index));
     m_driverController.leftBumper().whileTrue(new ShootH(m_index));
    m_driverController.rightTrigger().toggleOnTrue(new shootershort(m_bshooterHS));
    m_driverController.leftTrigger().toggleOnTrue(new shooterlong(m_bshooterHL));
    m_driverController.rightTrigger().toggleOnTrue(new flywheelH(m_Flywheel));
     m_driverController.leftTrigger().toggleOnTrue(new flywheelH(m_Flywheel));



    m_driverController.leftStick().whileTrue(m_robotDrive.setXCommand());
    m_driverController.start().onTrue(m_robotDrive.zeroHeadingCommand());

    m_CoDriverController.leftBumper().toggleOnTrue(new IntakeN(m_intake));
    m_CoDriverController.rightBumper().whileTrue(new IntakepivotN(m_Intakepivot));
    m_CoDriverController.rightTrigger().whileTrue(new pivotdown(m_Intakepivot));
    m_CoDriverController.y().whileTrue(new endgameT(m_endgame));
    m_CoDriverController.a().whileTrue(new endgameout(m_endgame));
    // Right Trigger -> Run fuel intake in reverse
   

    // Left Trigger -> Run fuel intake in reverse
   

    // Y Button -> Run intake and run the shooter flywheel and feeder
    

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  }
}
