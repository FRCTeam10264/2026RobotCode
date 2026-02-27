// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;


public class Bshooterwheel extends SubsystemBase {
  public double shooterwheelBSpeedSHORT = -0.8;
  public double shooterwheelBLSpeedLONG = -0.8;
  private SparkMax shooterwheelBSparkMax = new SparkMax(MechanismConstants.kBrollersshooterPort, MotorType.kBrushless);
  
   public Bshooterwheel() {

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
}