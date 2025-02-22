// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

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

/**
 * @author ServoHub
 */
public class ClimberSubsystem extends SubsystemBase {

  private SparkMax motor;
  private double position;
  private SparkMaxConfig config;

  private static ClimberSubsystem instance;

  public static ClimberSubsystem getInstance() {
    if (instance == null) instance = new ClimberSubsystem();
    return instance;
  }
  /** Creates a new CoralPivotSubsystem. */
  public ClimberSubsystem() {
    motor = new SparkMax(Constants.MotorIDConstants.motorClimber, MotorType.kBrushless);
    motor.getEncoder().setPosition(Constants.ClimberConstants.floorPosition);
    position = Constants.ClimberConstants.floorPosition;
    
    config = new SparkMaxConfig();
    config.inverted(false).idleMode(IdleMode.kBrake);
    config.encoder.positionConversionFactor(1).velocityConversionFactor(1);
    config.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder).pid(.5, 0.0, .5);
    motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // MotorConfiguration.configureMotor(motor, Constants.ClimberConstants.config);
  }

  public void setPosition(double pos) {
    position = pos;
  }

  public void changePosition(double changePos) {
    position += changePos;
  }

  public void setSpeed(double speed) {
    if ((speed > 0 && motor.getEncoder().getPosition() > Constants.ClimberConstants.maxPosition) || speed <= 0)
      motor.set(speed);
    position = -motor.getEncoder().getPosition();
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
    if (position <= Constants.ClimberConstants.maxPosition) {
      motor.getClosedLoopController().setReference(position, ControlType.kPosition);
    }
  }
}