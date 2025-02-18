package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;

public class Inputs {

    private static final XboxController driver1 = new XboxController(OperatorConstants.kDriverControllerPort);
	private static final CommandXboxController driver1Com = new CommandXboxController(OperatorConstants.kDriverControllerPort);
    
    
	public static double getSpeed() {
        double speed = driver1.getRightX();
        return speed;
    }

    public static boolean getTriggers() {
        return driver1.getLeftBumperButton() || driver1.getRightBumperButton();
    }

    public static double getTurn() {
        double turn = driver1.getLeftY();
        return turn;
    }

    public static Trigger getOutake() {
        return driver1Com.leftBumper();
    }

    public static Trigger getIntake() {
        return driver1Com.rightBumper();
    }

    public static Trigger getGoToClimberPosition() {
        return driver1Com.b();
    }

    public static Trigger getGoToFloor() {
        return driver1Com.a();
    }

    public static Trigger getGoToFloorP() {
        return driver1Com.povUp();
    }

    public static Trigger getGoToPivotPosition() {
        return driver1Com.povDown();
    }

    public static Trigger getChangeLeft() {
        return driver1Com.povLeft();
    }

    

    public static Trigger getChangeRight() {
        return driver1Com.povRight();
    }
}
