// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.MotorConfiguration;

public class ClimberSubsystem extends SubsystemBase {

  private TalonFX motor;
  private double position;
  final DutyCycleOut request = new DutyCycleOut(0.0);

  private static ClimberSubsystem instance;

  public static ClimberSubsystem getInstance() {
    if (instance == null) instance = new ClimberSubsystem();
    return instance;
  }
  /** Creates a new CoralPivotSubsystem. */
  public ClimberSubsystem() {
    // motor = new TalonFX(Constants.MotorIDConstants.motorClimber);
    MotorConfiguration.configureMotor(motor, Constants.ClimberConstants.config);
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
    return motor.getPosition().getValueAsDouble();
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
      motor.setPosition(position);
    }
  }
}