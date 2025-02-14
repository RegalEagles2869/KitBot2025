// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.MotorConfiguration;

public class ClimberSubsystem extends SubsystemBase {

  private TalonFX motor;
  private double position;
  
  private static ClimberSubsystem instance;

  public static ClimberSubsystem getInstance() {
    if (instance == null) instance = new ClimberSubsystem();
    return instance;
  }
  /** Creates a new CoralPivotSubsystem. */
  public ClimberSubsystem() {
    motor = new TalonFX(Constants.MotorIDConstants.motorClimber);
    MotorConfiguration.configureMotor(motor, Constants.ClimberConstants.config);
  }

  public void setPosition(double pos) {
    position = pos;
  }

  public void changePosition(double changePos) {
    position += changePos;
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
    if (position >= Constants.ClimberConstants.floorPosition && position < Constants.ClimberConstants.maxPosition) {
      motor.setPosition(position);
    }
  }
}