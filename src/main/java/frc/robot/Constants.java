// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final double slowSpeedMultiplier = .5;
    public static final int kOperatorControllerPort = 1;
  }
  
  public static class MotorIDConstants {
    public static final int motorFrontLeft = 3;
    public static final int motorFrontRight = 1;
    public static final int motorBackLeft = 4;
    public static final int motorBackRight = 2;
    public static final int motorClimber = 5;
    public static final int motorIntake = 6;
    public static final int motorPivot = 7;
  }

  public static class ClimberConstants {
    public static final double floorPosition = 73.5;
    public static final double maxPosition = 100000;
    public static final double goodPosition = 330;
    public static final double error = 1;
    public static final double positionChange = .1;
    
    public static final MotorConfiguration config = new MotorConfiguration(1, -1, 40, true, false);
  }

  public static class PivotConstants {
    public static final double floorPosition = 0;
    public static final double maxPosition = 100000;
    public static final double ballsPosition = -5.4;
    public static final double ballsGrabbedPosition = -1.85;
    public static final double error = 1;
    public static final double positionChange = .1;

    public static final MotorConfiguration config = new MotorConfiguration(1, -1, 40, true, false);
    public static final double minPosition = -10000000;
  }

}
