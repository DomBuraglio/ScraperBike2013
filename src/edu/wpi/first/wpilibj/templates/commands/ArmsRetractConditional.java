/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.Arms;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 *we may not use this, it has errors currently
 * @author bradmiller
 */
public class ArmsRetractConditional extends CommandBase {
    private Arms arm;
    private DriveTrain dt;
    private boolean started;
    
    public ArmsRetractConditional() {
        arm = ScraperBike.getArms();
        dt = ScraperBike.getDriveTrain();
        requires(arm);
        requires(dt);
        started = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run, allows arms to retract only if they are hooked on to the bar on the pyramid
    protected void execute() {
        if (arm.isContacting()) {
            started = true;
        }
        if (started) {
            arm.move(-1);    
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return started;
    }

    // Called once after isFinished returns true
    protected void end() {
         arm.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
         arm.move(0);
    }
}
