package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.flywheel2;

public class idleflywheel2 extends Command{
    private final flywheel2 m_Flywheel;
    
    public idleflywheel2(flywheel2 ind) {
        m_Flywheel = ind;
        addRequirements(m_Flywheel);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_Flywheel.flywheel2Run(m_Flywheel.idleflywheel2Speed);
    }

    @Override
    public void end(boolean interrupted) {
         m_Flywheel.flywheel2Stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}