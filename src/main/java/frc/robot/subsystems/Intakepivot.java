// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;


public class Intakepivot extends SubsystemBase {
  public double IntakepivotSpeed = 0.25;
  private SparkMax IntakepivotSparkMax = new SparkMax(MechanismConstants.kintakepivotPort, MotorType.kBrushless);
  private SparkClosedLoopController intakepivioController;


  public Intakepivot() {intakepivioController = IntakepivotSparkMax.getClosedLoopController();


  }

  public void IntakepivotRun(double speed) {
    IntakepivotSparkMax.set(speed);
  }

  public void IntakepivotOut(double speed) {
    IntakepivotSparkMax.set(-speed);
  }

  public void IntakepivotStop() {
    IntakepivotSparkMax.stopMotor();
  }

public void intakepos1(double Speed){
  intakepivioController.setSetpoint(0, ControlType.kPosition);

  }
  public void intakepos2(double intakepivotSpeed){
  intakepivioController.setSetpoint(-60, ControlType.kPosition);

  }
  public void intakepos3(double intakepivotSpeed){
  intakepivioController.setSetpoint(-90, ControlType.kPosition);

  }
}