package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooterwheelB;

public class shooterH extends Command{
    private final shooterwheelB m_bshooterH;   

    public shooterH(shooterwheelB ind) {
        m_bshooterH = ind;
        addRequirements(m_bshooterH);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_bshooterH.BshooterwheelRun(-m_bshooterH.flywheelSpeed);
    }

    @Override
    public void end(boolean interrupted) {
         m_bshooterH.BshooterwheelStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
