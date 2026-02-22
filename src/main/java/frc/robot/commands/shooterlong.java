package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.BshooterwheelL;

public class shooterlong extends Command{
    private final BshooterwheelL m_bshooterHL;   

    public shooterlong(BshooterwheelL ind) {
        m_bshooterHL = ind;
        addRequirements(m_bshooterHL);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_bshooterHL.BshooterwheelLRun(m_bshooterHL.shooterwheelBLSpeedL);
    }

    @Override
    public void end(boolean interrupted) {
         m_bshooterHL.BshooterwheelLStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
