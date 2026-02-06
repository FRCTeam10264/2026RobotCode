// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class intakerollers extends SubsystemBase {
  public double rollerSpeed = 1;
  private CANSparkMax rollerSparkMax = new CANSparkMax(MechanismConstants.krollerShooterPort, MotorType.kBrushless);
  
   public intakerollers() {

  }

  public void rollerrun(double speed) {
    rollerSparkMax.set(speed);
  }

  public void rollerreverse(double speed) {
    rollerSparkMax.set(-speed);
  }

  public void rollerStop() {
    rollerSparkMax.stopMotor();
  }
}
