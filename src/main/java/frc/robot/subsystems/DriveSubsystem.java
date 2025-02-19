package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase{
    
    private WPI_TalonSRX leftMotor1;
    private WPI_TalonSRX leftMotor2;
    private WPI_TalonSRX rightMotor1;
    private WPI_TalonSRX rightMotor2;

    private DifferentialDrive drive;

    private static DriveSubsystem ds;
    //talon.setNeutralMode(NeutralMode.)
    public DriveSubsystem() {
        leftMotor1 = new WPI_TalonSRX(Constants.MotorIDConstants.motorFrontLeft);
        leftMotor2 = new WPI_TalonSRX(Constants.MotorIDConstants.motorBackLeft);
        rightMotor1 = new WPI_TalonSRX(Constants.MotorIDConstants.motorFrontRight);
        rightMotor2 = new WPI_TalonSRX(Constants.MotorIDConstants.motorBackRight);
        leftMotor2.follow(leftMotor1);
        rightMotor2.follow(rightMotor1);
        // leftMotor2.setInverted(true);
        rightMotor1.setInverted(true);
        // rightMotor2.setInverted(true);
        // drive = new DifferentialDrive(leftMotor1, rightMotor1);
        drive = new DifferentialDrive(leftMotor1, rightMotor1);
    }

    public static DriveSubsystem getInstance() {
        if (ds == null) ds = new DriveSubsystem();
        return ds;
    }

    public void drive(double speed, double turn) {
        drive.arcadeDrive(speed, turn);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("left1", leftMotor1.getSupplyCurrent());
        SmartDashboard.putNumber("left2", leftMotor2.getSupplyCurrent());
        SmartDashboard.putNumber("right1", rightMotor1.getSupplyCurrent());
        SmartDashboard.putNumber("right2", rightMotor2.getSupplyCurrent());
    }
}
