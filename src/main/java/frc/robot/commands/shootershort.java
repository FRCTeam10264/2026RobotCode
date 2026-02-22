package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.BshooterwheelS;

public class shootershort extends Command{
    private final BshooterwheelS m_bshooterHS;   

    public shootershort(BshooterwheelS ind) {
        m_bshooterHS = ind;
        addRequirements(m_bshooterHS);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_bshooterHS.BshooterwheelSRun(m_bshooterHS.shooterwheelBSSpeed);
    }

    @Override
    public void end(boolean interrupted) {
         m_bshooterHS.BshooterwheelSStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

