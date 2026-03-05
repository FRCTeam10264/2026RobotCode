// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.events.EventTrigger;
import com.pathplanner.lib.path.GoalEndState;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.path.Waypoint;






public class RobotContainer {

  

   

 
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final Index m_index = new Index();
  private final Bshooterwheel m_bshooterHS = new Bshooterwheel();
  private final intakerollers m_intake = new intakerollers();
  private final flywheel m_Flywheel = new flywheel();
  private final Intakepivot m_Intakepivot = new Intakepivot();
  private final endgame m_endgame = new endgame();

  // The driver's controller
  private final CommandXboxController m_driverController =
      new CommandXboxController(OIConstants.kDriverControllerPort);
     
      private final CommandXboxController m_CoDriverController =
      new CommandXboxController(OIConstants.kCoDriverControllerPort);


  public RobotContainer() {
    
   
    configureBindings();

  
    m_robotDrive.setDefaultCommand(
      
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

 
  private void configureBindings() {
   
    m_driverController.leftStick().whileTrue(m_robotDrive.setXCommand());
    m_driverController.start().onTrue(m_robotDrive.zeroHeadingCommand());

    m_driverController.rightBumper().whileTrue(new indexe(m_index));
    m_driverController.leftBumper().whileTrue(new indexe(m_index));

    m_driverController.rightTrigger().toggleOnTrue(new shootersidewall(m_bshooterHS));
    m_driverController.rightTrigger().toggleOnTrue(new flywheelsidewall(m_Flywheel));
  
    m_driverController.leftTrigger().toggleOnTrue(new shootertower(m_bshooterHS));
    m_driverController.leftTrigger().toggleOnTrue(new flywheeltower(m_Flywheel));
   
    m_driverController.x().whileTrue(new indexerclear(m_index));
    m_driverController.x().whileTrue(new flywheelclear(m_Flywheel));


    m_driverController.leftStick().whileTrue(m_robotDrive.setXCommand());
    m_driverController.start().onTrue(m_robotDrive.zeroHeadingCommand());

    m_CoDriverController.x().whileTrue(new indexerclear(m_index));
    m_CoDriverController.x().whileTrue(new flywheelclear(m_Flywheel));

    m_CoDriverController.leftBumper().toggleOnTrue(new IntakeN(m_intake));

    m_CoDriverController.rightBumper().whileTrue(new IntakepivotN(m_Intakepivot));

    m_CoDriverController.rightTrigger().whileTrue(new pivotdown(m_Intakepivot));

    m_CoDriverController.y().whileTrue(new endgameT(m_endgame));

    m_CoDriverController.a().whileTrue(new endgameout(m_endgame));

    m_CoDriverController.povUp().whileTrue(new pivotpos1(m_Intakepivot));
    m_CoDriverController.povDown().whileTrue(new pivotpos2(m_Intakepivot));
    m_CoDriverController.povRight().whileTrue(new pivotpos3(m_Intakepivot));




    m_CoDriverController.start().onTrue(new idleindexer(m_index));
    m_CoDriverController.start().onTrue(new idleflywheel(m_Flywheel));
  
  }
}
