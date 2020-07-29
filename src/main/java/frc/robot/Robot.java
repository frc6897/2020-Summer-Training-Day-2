// Advik Lall, Kevin May

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


// Hi, my name is Aryan. I put these comments in the code to help you better understand.

package frc.robot;

/*
  If you go to your folder folders on the left side of VS Code. You will see a section called Venderdeps under Robot.java.
  Essentially, the vendor libraries that you add will appear there at that location. What these import statement do is that
  they pull the infromation from those Vendor Dependicies and allow us to use their commands in our code. For instance, the 
  com.ctre.pheonix.motorcontrol.TalonSRX allows us to take control of the Talon SRX speed controller. 
*/
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  /*
  What lines 45 and 46 are doing is they are creating a variable by which we can call back the Speed Controller
  and the Talon SRX. The joy1 variable is creating a new Joystick variable for a controller connected on Port 0. The ports of
  the controller can be checked using Driver Station. The talon 1 variable is creating a new Talon SRX variable for
  a speed controller connected on Port 0. The port can be checked using Pheonix Tuner. 
  */
  private Joystick joy1 = new Joystick(0);
  private TalonSRX talon1 = new TalonSRX(0);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called once when teleop is enabled.
   */
  @Override
  public void teleopInit() {

  }


  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    
    /*
      This void method is called Teleop Periodic. As you know, Teleop is a mode in Driver Station that can be turned
      off or on. What teleopPeriodic does is that it runs the following code every 20ms. 20ms is really fast as an FYI. 
      What this means is that this method is basically looping the code within it as long as telop is on. What line 128 
      is doing is it's setting the speed of the Talon SRX to the value of the Joystick's first axis. What ControlMode.
      PercentOutput is doing is it's basically saying that the motor is going to give some output which means it's going
      to spin. 
    */
    talon1.set(ControlMode.PercentOutput, joy1.getRawAxis(1));


  }

  /**
   * This function is called once when the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  /**
   * This function is called periodically when disabled.
   */
  @Override
  public void disabledPeriodic() {
  }

  /**
   * This function is called once when test mode is enabled.
   */
  @Override
  public void testInit() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
