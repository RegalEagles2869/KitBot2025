// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

 
/**
 * Outake Subsystem -- Controls Outake of KIT BOT and adds motor1 speed functionality
 * @author idk
 */
public class OutakeSubsystem extends SubsystemBase {
      private WPI_TalonSRX motor1;


      private static OutakeSubsystem os;


    public static OutakeSubsystem getInstance() {
        if (os == null) os = new OutakeSubsystem();
        return os;
    }

  /** Creates a new OutakeSubsystem. */
  public OutakeSubsystem() {

    motor1 = new WPI_TalonSRX(Constants.MotorIDConstants.motorOutake);


  }


  public void motor1(double speed){
    motor1.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
