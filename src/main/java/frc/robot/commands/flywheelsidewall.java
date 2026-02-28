package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.flywheel;

public class flywheelsidewall extends Command{
    private final flywheel m_Flywheel;
    
    public flywheelsidewall(flywheel ind) {
        m_Flywheel = ind;
        addRequirements(m_Flywheel);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_Flywheel.flywheelRun(m_Flywheel.flywheelsidewallSpeed);
    }

    @Override
    public void end(boolean interrupted) {
         m_Flywheel.flywheelStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
