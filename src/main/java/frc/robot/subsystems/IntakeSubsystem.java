// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

 
/**
 * Outake Subsystem -- Controls Outake of KIT BOT and adds motor1 speed functionality
 * @author idk
 */
public class IntakeSubsystem extends SubsystemBase {
  private WPI_TalonSRX motor;


  private static IntakeSubsystem instance;


  public static IntakeSubsystem getInstance() {
    if (instance == null) instance = new IntakeSubsystem();
    return instance;
  }

  /** Creates a new OutakeSubsystem. */
  public IntakeSubsystem() {
    motor = new WPI_TalonSRX(Constants.MotorIDConstants.motorIntake);
  }

  public void set(double speed) {
    System.out.println(speed);
    motor.set(speed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
