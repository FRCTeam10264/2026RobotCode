package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intakepivot;

public class pivotpos3 extends Command{
    private final Intakepivot m_Intakepivot;
    
    public pivotpos3(Intakepivot ind) {
        m_Intakepivot = ind;
        addRequirements(m_Intakepivot);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_Intakepivot.intakepos3(-m_Intakepivot.IntakepivotSpeed);
    }

    @Override

    public void end(boolean interrupted) {
         m_Intakepivot.IntakepivotStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}