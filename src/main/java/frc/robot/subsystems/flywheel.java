// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;


public class flywheel extends SubsystemBase {
  public double flywheeltowerSpeed = -.53;
  public double flywheelsidewallSpeed = -.53;
  
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