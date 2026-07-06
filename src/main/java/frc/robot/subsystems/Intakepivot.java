// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import com.revrobotics.jni.DetachedEncoderJNI;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs;
import frc.robot.Constants.MechanismConstants;


public class Intakepivot extends SubsystemBase {
  public double IntakepivotSpeed = 0.25;
  private SparkMax IntakepivotSparkMax = new SparkMax(MechanismConstants.kintakepivotPort, MotorType.kBrushless);
  private SparkClosedLoopController intakepivioController;
private SparkMaxConfig config = new SparkMaxConfig();
  
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