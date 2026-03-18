// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.IntakeN;
import frc.robot.commands.endgameT;
import frc.robot.commands.endgameout;
import frc.robot.commands.flywheel1other;
import frc.robot.commands.flywheel1ramp;
import frc.robot.commands.flywheel2other;
import frc.robot.commands.flywheel2ramp;
import frc.robot.commands.idleflywheel1;
import frc.robot.commands.idleindexer;
import frc.robot.commands.indexe;
import frc.robot.commands.indexerclear;
import frc.robot.commands.pivotdown;
import frc.robot.commands.pivotpos1;
import frc.robot.commands.pivotpos2;
import frc.robot.commands.pivotpos3;
import frc.robot.commands.pivotup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.Intakepivot;
import frc.robot.subsystems.endgame;
import frc.robot.subsystems.flywheel1;
import frc.robot.subsystems.flywheel2;
import frc.robot.subsystems.intakerollers;






public class RobotContainer {
  
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final SendableChooser<Command> autoChooser;

private final SlewRateLimiter xLimiter = new SlewRateLimiter(3.0);
private final SlewRateLimiter yLimiter = new SlewRateLimiter(3.0);
private final SlewRateLimiter rotLimiter = new SlewRateLimiter(4.0);
  private final Index m_index = new Index();
  //private final Bshooterwheel m_bshooterHS = new Bshooterwheel();
  private final intakerollers m_intake = new intakerollers();
  private final flywheel1 m_Flywheel1 = new flywheel1();
  private final Intakepivot m_Intakepivot = new Intakepivot();
  private final endgame m_endgame = new endgame();
  private final flywheel2 m_Flywheel2 = new flywheel2();

  // The driver's controller
  private final CommandXboxController m_driverController =
      new CommandXboxController(OIConstants.kDriverControllerPort);
     
      private final CommandXboxController m_CoDriverController =
      new CommandXboxController(OIConstants.kCoDriverControllerPort);

 public Command getAutonomousCommand() {
   
  Command command  = autoChooser.getSelected();
  return command;
  }
  
 

 

  public RobotContainer() {


     ///DriveSubsystem m_robotDrive = new DriveSubsystem();
        //exampleSubsystem = new ExampleSubsystem(); inilisation command if ones above dont work

        // Register Named Commands
      
        ///NamedCommands.registerCommand("shoot sidewall", new shootersidewall(m_bshooterHS));
        //NamedCommands.registerCommand("shoot tower", new shootertower(m_bshooterHS));
        NamedCommands.registerCommand("climbtower", new endgameT(m_endgame));
        NamedCommands.registerCommand("pivotdown", new pivotdown(m_Intakepivot));
        NamedCommands.registerCommand("pivotup", new pivotup(m_Intakepivot));
        NamedCommands.registerCommand("intakerollers", new IntakeN(m_intake));
        NamedCommands.registerCommand("index", new indexe(m_index));
        NamedCommands.registerCommand("mainfly1", new flywheel1ramp(m_Flywheel1));
         NamedCommands.registerCommand("mainfly2", new flywheel2ramp(m_Flywheel2));


        // new EventTrigger("shoot note").and(new Trigger(exampleSubsystem::someCondition)).onTrue(Commands.print("shoot note");


       // new PointTowardsZoneTrigger("Speaker").whileTrue(Commands.print("aiming at speaker"));


double x = -MathUtil.applyDeadband(
m_driverController.getLeftY(), OIConstants.kDriveDeadband);

double y = -MathUtil.applyDeadband(
m_driverController.getLeftX(), OIConstants.kDriveDeadband);

double rot = -MathUtil.applyDeadband(
m_driverController.getRightX(), OIConstants.kDriveDeadband);


 x = xLimiter.calculate(x);
 y = yLimiter.calculate(y);
 rot = rotLimiter.calculate(rot);

 m_robotDrive.drive(x, y, rot, true);




        

 
 SmartDashboard.putNumber("Bat Voltage", RobotController.getBatteryVoltage());
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




    boolean isCompetition = true;

   
    autoChooser = AutoBuilder.buildAutoChooser(
    );

    SmartDashboard.putData("Auto Chooser", autoChooser);
  
    
  }



  







    

    // ...

    // Build an auto chooser. This will use Commands.none() as the default option.
    

    // Another option that allows you to specify the default auto by its name
    // autoChooser = AutoBuilder.buildAutoChooser("My Default Auto");

   
  

  
  private void configureBindings() {
    

    m_driverController.leftStick().whileTrue(m_robotDrive.setXCommand());
    m_driverController.start().onTrue(m_robotDrive.zeroHeadingCommand());

    m_driverController.rightBumper().whileTrue(new indexe(m_index));
    m_driverController.leftBumper().whileTrue(new indexe(m_index));

   /// m_driverController.rightTrigger().toggleOnTrue(new shootersidewall(m_bshooterHS));
    m_driverController.rightTrigger().toggleOnTrue(new flywheel1other(m_Flywheel1));
    m_driverController.rightTrigger().toggleOnTrue(new flywheel2other(m_Flywheel2));
  
    ///m_driverController.leftTrigger().toggleOnTrue(new shootertower(m_bshooterHS));
    m_driverController.leftTrigger().toggleOnTrue(new flywheel1ramp(m_Flywheel1));
    m_driverController.leftTrigger().toggleOnTrue(new flywheel2ramp(m_Flywheel2));
   
    m_driverController.x().whileTrue(new indexerclear(m_index));
   // m_driverController.x().whileTrue(new flywheel1clear(m_Flywheel1));


    m_driverController.leftStick().whileTrue(m_robotDrive.setXCommand());
    m_driverController.start().onTrue(m_robotDrive.zeroHeadingCommand());

    m_CoDriverController.x().whileTrue(new indexerclear(m_index));
    //m_CoDriverController.x().whileTrue(new flywheel1clear(m_Flywheel1));

    m_CoDriverController.leftBumper().toggleOnTrue(new IntakeN(m_intake));

    m_CoDriverController.rightBumper().whileTrue(new pivotup(m_Intakepivot));
    m_CoDriverController.rightTrigger().whileTrue(new pivotdown(m_Intakepivot));

    m_CoDriverController.y().whileTrue(new endgameT(m_endgame));

    m_CoDriverController.a().whileTrue(new endgameout(m_endgame));

    m_CoDriverController.povUp().whileTrue(new pivotpos1(m_Intakepivot));
    m_CoDriverController.povDown().whileTrue(new pivotpos2(m_Intakepivot));
    m_CoDriverController.povRight().whileTrue(new pivotpos3(m_Intakepivot));

  


    m_CoDriverController.start().onTrue(new idleindexer(m_index));
    m_CoDriverController.start().onTrue(new idleflywheel1(m_Flywheel1));

  

  
  }
}