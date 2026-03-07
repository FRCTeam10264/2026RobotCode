package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.flywheel2;

public class flywheel2ramp extends Command{
    private final flywheel2 m_Flywheel2;
    
    public flywheel2ramp(flywheel2 ind) {
        m_Flywheel2 = ind;
        addRequirements(m_Flywheel2);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_Flywheel2.flywheel2Run(m_Flywheel2.flywheel2rampSpeed);
    }

    @Override
    public void end(boolean interrupted) {
         m_Flywheel2.flywheel2Stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
