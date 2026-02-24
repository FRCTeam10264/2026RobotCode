package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Bshooterwheel;

public class shootershort extends Command{
    private final Bshooterwheel m_bshooterHS;   

    public shootershort(Bshooterwheel ind) {
        m_bshooterHS = ind;
        addRequirements(m_bshooterHS);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_bshooterHS.BshooterwheelRun(m_bshooterHS.shooterwheelBSpeedSHORT);
    }

    @Override
    public void end(boolean interrupted) {
         m_bshooterHS.BshooterwheelStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

