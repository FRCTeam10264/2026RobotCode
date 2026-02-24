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


public class Bshooterwheel extends SubsystemBase {
  
    public double shooterwheelBLSpeed = -0.8;
    public double shooterwheelBSSpeed = -0.8;
    
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