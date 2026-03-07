/*package frc.robot.commands;

 import edu.wpi.first.wpilibj2.command.Command;
 import frc.robot.subsystems.Bshooterwheel;

 public class shootertower extends Command{
     private final Bshooterwheel m_bshooter;   

     public shootertower(Bshooterwheel ind) {
         m_bshooter = ind;
         addRequirements(m_bshooter);
     }

      @Override
      public void initialize(){}

     @Override
     public void execute() {
          m_bshooter.BshooterwheelRun(m_bshooter.shooterwheelBLSpeedLONG);
     }

     @Override
     public void end(boolean interrupted) {
          m_bshooter.BshooterwheelStop();
     }

     @Override
     public boolean isFinished() {
         return false;
     }
}*/