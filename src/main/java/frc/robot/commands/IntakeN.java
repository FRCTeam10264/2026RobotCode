package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intakerollers;

public class IntakeN extends Command{
    private final intakerollers m_intake;
    
    public IntakeN(intakerollers ind) {
        m_intake = ind;
        addRequirements(m_intake);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_intake.rollerrun(-m_intake.rollerSpeed);
    }

    @Override
    public void end(boolean interrupted) {
         m_intake.rollerStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
