// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.ChangePositionIntake;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.PositionSetClimber;
import frc.robot.commands.PositionSetIntake;
import frc.robot.commands.SpinOutake;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private DriveSubsystem driveSubsytem;

  // Replace with CommandPS4Controller or CommandJoystick if needed

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveSubsytem = DriveSubsystem.getInstance();
    // Configure the trigger bindings
    configureBindings();

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    driveSubsytem.setDefaultCommand(new DefaultDriveCommand());
    Inputs.getGoToClimberPosition().onTrue(new PositionSetClimber(Constants.ClimberConstants.goodPosition));
    Inputs.getGoToFloor().onTrue(new PositionSetClimber(Constants.ClimberConstants.floorPosition));
    Inputs.getOutake().whileTrue(new SpinOutake(1));
    Inputs.getIntake().whileTrue(new SpinOutake(-1));
    Inputs.getGoToFloorP().onTrue(new PositionSetIntake(Constants.PivotConstants.startingPosition));
    Inputs.getGoToPivotPosition().onTrue(new PositionSetIntake(Constants.PivotConstants.ballsPosition));

    Inputs.getChangeLeft().onTrue(new ChangePositionIntake(Constants.PivotConstants.positionChange));
    Inputs.getChangeRight().onTrue(new ChangePositionIntake(-Constants.PivotConstants.positionChange));
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new ParallelDeadlineGroup(new AutoCommand(), new WaitCommand(5));
  }
}
