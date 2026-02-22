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
import frc.robot.Constant.MechanismConstants;


public class flywheel extends SubsystemBase {
  public double flywheelSpeed = -.55;
  private SparkMax flywheelSparkMax = new SparkMax(MechanismConstants.kflywheelShooterPort, MotorType.kBrushless);
  
   public flywheel() {

  }

  public void flywheelRun(double speed) {
    flywheelSparkMax.set(speed);
  }

  public void flywheelOut(double speed) {
    flywheelSparkMax.set(-speed);
  }

  public void flywheelStop() {
    flywheelSparkMax.stopMotor();
  }
}