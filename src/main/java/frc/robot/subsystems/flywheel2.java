// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;


public class flywheel2 extends SubsystemBase {
  public double flywheel2rampSpeed = .7;
  public double flywheel2sidewallSpeed = .7;
  public double idleflywheel2Speed = .7;
  private SparkMax flywheel2SparkMax = new SparkMax(MechanismConstants.kflywheel2ShooterPort, MotorType.kBrushless);

  
   public flywheel2() {

  }

  public void flywheel2Run(double speed) {
    flywheel2SparkMax.set(speed);
  }

  public void flywheel2Out(double speed) {
    flywheel2SparkMax.set(-speed);
  }

  public void flywheel2Stop() {
    flywheel2SparkMax.stopMotor();
  }
}