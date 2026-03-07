package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.flywheel1;

public class idleflywheel1 extends Command{
    private final flywheel1 m_Flywheel;
    
    public idleflywheel1(flywheel1 ind) {
        m_Flywheel = ind;
        addRequirements(m_Flywheel);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_Flywheel.flywheel1Run(m_Flywheel.idleflywheel1Speed);
    }

    @Override
    public void end(boolean interrupted) {
         m_Flywheel.flywheel1Stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}