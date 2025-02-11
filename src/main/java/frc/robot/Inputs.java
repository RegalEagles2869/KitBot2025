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

    public static double getTurn() {
        double turn = driver1.getLeftY();
        return turn;
    }

    public static Trigger getGoDown() {
        return driver1Com.x();
    }

    public static Trigger getOuttake() {
        return driver1Com.a();
    }
    public static Trigger getGoUp() {
        return driver1Com.y();
    }
}
