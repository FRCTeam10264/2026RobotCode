package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.endgame;

public class endgameout extends Command{
    private final endgame m_endgame;
    
    public endgameout(endgame ind) {
        m_endgame = ind;
        addRequirements(m_endgame);
    }

     @Override
     public void initialize(){}

    @Override
    public void execute() {
         m_endgame.endgameOut(-m_endgame.endgameSpeed);
    }

    @Override

    
    public void end(boolean interrupted) {
         m_endgame.endgameStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
