package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Index;

public class idleindexer extends Command{
    private final Index m_index;
    
    public idleindexer(Index ind) {
        m_index = ind;
        addRequirements(m_index);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_index.indexRun(m_index.idleindexSpeed);
    }

    @Override
    public void end(boolean interrupted) {
         m_index.indexStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}