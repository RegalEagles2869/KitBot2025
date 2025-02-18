// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PivotSubsystem extends SubsystemBase {

  private WPI_TalonSRX motor;

  private static PivotSubsystem instance;

  public static PivotSubsystem getInstance() {
    if (instance == null) instance = new PivotSubsystem();
    return instance;
  }
  /** Creates a new CoralPivotSubsystem. */
  public PivotSubsystem() {
    motor = new WPI_TalonSRX(Constants.MotorIDConstants.motorIntake);
  }

  public void set(double speed) {
    motor.set(speed);
  }
}
