// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;


public class flywheel1 extends SubsystemBase {
  public double flywheel1towerSpeed = -.76;
  public double flywheel1sidewallSpeed = -.76;
  private SparkMax flywheel1SparkMax = new SparkMax(MechanismConstants.kflywheel1ShooterPort, MotorType.kBrushless);

  
   public flywheel1() {

  }

  public void flywheel1Run(double speed) {
    flywheel1SparkMax.set(speed);
  }

  public void flywheel1Out(double speed) {
    flywheel1SparkMax.set(-speed);
  }

  public void flywheel1Stop() {
    flywheel1SparkMax.stopMotor();
  }
}