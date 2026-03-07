package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.flywheel1;

public class flywheel1ramp extends Command{
    private final flywheel1 m_Flywheel1;
    
    public flywheel1ramp(flywheel1 ind) {
        m_Flywheel1 = ind;
        addRequirements(m_Flywheel1);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_Flywheel1.flywheel1Run(m_Flywheel1.flywheel1towerSpeed);
    }

    @Override
    public void end(boolean interrupted) {
         m_Flywheel1.flywheel1Stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
