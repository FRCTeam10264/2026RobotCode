// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkClosedLoopController;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;


public class Intakepivot extends SubsystemBase {
  public double IntakepivotSpeed = 0.05;
  private SparkMax IntakepivotSparkMax = new SparkMax(MechanismConstants.kintakepivotPort, MotorType.kBrushless);
  
   public Intakepivot() {

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
}