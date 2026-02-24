// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constant {
public static class OperatorConstant {
    public static final int kDriverControllerPort = 0;
    public static final int kCoDriverControllerPort = 1;
  
   
  }
public static final class DriveConstants {


  public static final int kIMU_ID = 10;
    // Driving Parameters - Note that these are not the maximum capable speeds of
    // the robot, rather the allowed maximum speeds//////////////////////////////////////////////////////////////
    public static final double kMaxSpeedMetersPerSecond = 4.8;
    ////////////////////////////////////////////////////////////////////////////////max speed////////////////////
    public static final double kMaxAngularSpeed = 2 * Math.PI; // radians per second

    // Chassis configuration
    public static final double kTrackWidth = Units.inchesToMeters(21.5);
    // Distance between centers of right and left wheels on robot
    public static final double kWheelBase = Units.inchesToMeters(21.5);
    // Distance between front and back wheels on robot
    public static final SwerveDriveKinematics kDriveKinematics =
        new SwerveDriveKinematics(
            new Translation2d(kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));
 // Angular offsets of the modules relative to the chassis in radians
    public static final double kFrontLeftChassisAngularOffset = -Math.PI / 2;
    public static final double kFrontRightChassisAngularOffset = 0;
    public static final double kBackLeftChassisAngularOffset = Math.PI;
    public static final double kBackRightChassisAngularOffset = Math.PI / 2;

    // SPARK MAX CAN IDs
    public static final int kFrontLeftDrivingCanId = 7;
    public static final int kRearLeftDrivingCanId = 8;
    public static final int kFrontRightDrivingCanId = 4;
    public static final int kRearRightDrivingCanId = 2;

    public static final int kFrontLeftTurningCanId = 6;
    public static final int kRearLeftTurningCanId = 9;
    public static final int kFrontRightTurningCanId = 5;
       public static final int kRearRightTurningCanId = 3;
    public static final boolean kGyroReversed = false;
}  
public static final class MechanismConstants{
  public static final int kendgamePort = 16;
  public static final int kflywheelShooterPort = 11;
  public static final int kIndexShooterPort = 12;
  public static final int kintakepivotPort = 13;
  public static final int kintakerollersPort = 14;
  public static final int kBrollersshooterPort = 15;
 }
public static final class ModuleConstants{
    public static final int kDrivingMotorPinionTeeth = 14;
    public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
    public static final double kWheelDiameterMeters = Units.inchesToMeters(3);
    public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
    public static final double kDrivingWheelBevelGearTeeth = 45.0;
    public static final double kDrivingWheelFirstStageSpurGearTeeth = 22.0;
    public static final double kDrivingMotorBevelPinionTeeth = 15.0;
    public static final double kDrivingMotorReduction = (kDrivingWheelBevelGearTeeth * kDrivingWheelFirstStageSpurGearTeeth)
        / (kDrivingMotorPinionTeeth * kDrivingMotorBevelPinionTeeth);
    public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
        / kDrivingMotorReduction;
  }

public final class OIConstant {
    public static final double kDriveDeadband = 0.1;
    public static final double kTriggerButtonThreshold = 0.2;
  }
public static final class NeoMotorConstants {
    public static final double kFreeSpeedRpm = 5676;
    public static final double kVortexKv = 565;   // rpm/V
  }
public static final class speeds{
    public double shooterwheelBLSpeed = -0.8;
    public double shooterwheelBSSpeed = -0.8;

  
}
}
//all below this is currently expermental
