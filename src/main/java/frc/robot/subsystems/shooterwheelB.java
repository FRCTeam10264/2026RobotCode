// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;


public class shooterwheelB extends SubsystemBase {
  public double flywheelSpeed = 1;
  private CANSparkMax flywheelSparkMax = new CANSparkMax(MechanismConstants.kIndexShooterPort, MotorType.kBrushless);
  
   public shooterwheelB() {

  }

  public void BshooterwheelRun(double speed) {
    shooterwheelBSparkMax.set(speed);
  }

  public void BshooterwheelOut(double speed) {
    shooterwheelBSparkMax.set(-speed);
  }

  public void BshooterwheelStop() {
    shooterwheelBSparkMax.stopMotor();
  }
