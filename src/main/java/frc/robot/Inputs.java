package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;

public class Inputs {

    private static final XboxController driver1 = new XboxController(OperatorConstants.kDriverControllerPort);
	private static final CommandXboxController driver1Com = new CommandXboxController(OperatorConstants.kOperatorControllerPort);
	private static final CommandXboxController driverCom = new CommandXboxController(OperatorConstants.kDriverControllerPort);
    
    
	public static double getSpeed() {
        double speed = driver1.getRightX();
        return speed;
    }

    public static boolean getAButtonDrive() {
        return driver1.getAButton();
    }

    public static Trigger getRUMBLERUMBLE2() {
        return driverCom.b();
    }

    public static double getTurn() {
        double turn = driver1.getLeftY();
        return turn;
    }

    public static Trigger getOutake() {
        return driver1Com.leftBumper();
    }

    public static Trigger getClimbOrigin() {
        return driver1Com.a();
    }

    public static Trigger getIntake() {
        return driver1Com.rightBumper();
    }

    public static Trigger getGoToClimberPosition() {
        return driver1Com.b();
    }

    public static Trigger getGoToFloorPivot() {
        return driver1Com.y();
    }

    public static Trigger getRUMBLE() {
        return driver1Com.button(7);
    }

    public static Trigger getClimberDown() {
        return driver1Com.povUp();
    }

    public static Trigger getClimberUp() {
        return driver1Com.povDown();
    }

    public static Trigger getChangeLeft() {
        return driver1Com.povLeft();
    }

    public static Trigger getBallsMidPosition() {
        return driver1Com.button(8);
    }

    public static Trigger getChangeRight() {
        return driver1Com.povRight();
    }

    public static Trigger getGoToBallsPosition() {
        return driver1Com.x();
    }

    public static void RUMBLERUMBLE(double rumble) {
        try {
            driver1.setRumble(RumbleType.kBothRumble, rumble);
        } catch (Exception e) {}
    }

    public static void RUMBLERUMBLE2(double rumble) {
        try {
            driver1Com.setRumble(RumbleType.kBothRumble, rumble);
        } catch (Exception e) {}
    }
}
