// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

  private SparkMax motor;
  private double position;
  final DutyCycleOut request = new DutyCycleOut(0.0);
  private SparkMaxConfig config;

  private static ClimberSubsystem instance;

  public static ClimberSubsystem getInstance() {
    if (instance == null) instance = new ClimberSubsystem();
    return instance;
  }
  /** Creates a new CoralPivotSubsystem. */
  public ClimberSubsystem() {
    motor = new SparkMax(Constants.MotorIDConstants.motorClimber, MotorType.kBrushless);
    motor.getEncoder().setPosition(0);
    
    // config = new SparkMaxConfig();
    // config.inverted(false).idleMode(IdleMode.kBrake);
    // config.encoder.positionConversionFactor(1000).velocityConversionFactor(1000);
    // config.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder).pid(1.0, 0.0, 0.0);
    // motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // MotorConfiguration.configureMotor(motor, Constants.ClimberConstants.config);
  }

  public void setPosition(double pos) {
    position = pos;
  }

  public void changePosition(double changePos) {
    position += changePos;
  }

  public void setSpeed(double speed) {
    if ((speed > 0 && motor.getEncoder().getPosition() < Constants.ClimberConstants.maxPosition) || (speed < 0 && motor.getEncoder().getPosition() > 0))
      motor.set(speed);
  }

  public double getPosition() {
    return motor.getEncoder().getPosition();
  }

  public boolean isAtPosition() {
    if ((getPosition() >= (position - Constants.ClimberConstants.error)) && (getPosition() <= (position + Constants.ClimberConstants.error)))
      return true;
    return false;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("positionLol", getPosition());
    SmartDashboard.putNumber("speedhAHA", motor.getEncoder().getVelocity());
    SmartDashboard.putNumber("speedhAHA2", motor.getAppliedOutput());
    if (position >= Constants.ClimberConstants.floorPosition && position < Constants.ClimberConstants.maxPosition) {
      System.out.println(position);
      motor.getClosedLoopController().setReference(position, ControlType.kPosition);
    }
  }
}