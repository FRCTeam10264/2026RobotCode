// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.ClosedLoopConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs;
import frc.robot.Constants.MechanismConstants;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;


public class Index extends SubsystemBase {
  public double indexSpeed = .85;
  public double idleindexSpeed = -.3;
  private SparkMax indexSparkMax = new SparkMax(MechanismConstants.kIndexShooterPort, MotorType.kBrushless);
  
   public Index() {
  }

  public void indexRun(double speed) {
    indexSparkMax.set(speed);
  }

  public void indexOut(double speed) {
    indexSparkMax.set(-speed);
  }

  public void indexStop() {
    indexSparkMax.stopMotor();
  }
}