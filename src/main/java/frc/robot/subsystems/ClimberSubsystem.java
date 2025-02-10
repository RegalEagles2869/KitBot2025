// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

  private SparkMax motor;
  private double position;
  final DutyCycleOut request = new DutyCycleOut(0.0);

  private static ClimberSubsystem instance;

  public static ClimberSubsystem getInstance() {
    if (instance == null) instance = new ClimberSubsystem();
    return instance;
  }
  /** Creates a new CoralPivotSubsystem. */
  public ClimberSubsystem() {
    motor = new SparkMax(Constants.MotorIDConstants.motorClimber, MotorType.kBrushless);
    // MotorConfiguration.configureMotor(motor, Constants.ClimberConstants.config);
  }

  public void setPosition(double pos) {
    position = pos;
  }

  public void changePosition(double changePos) {
    position += changePos;
  }

  public void setSpeed(double speed) {
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
    if (position >= Constants.ClimberConstants.floorPosition && position < Constants.ClimberConstants.maxPosition) {
      // motor.setPosition(position);
      motor.getEncoder().setPosition(position);
    }
  }
}