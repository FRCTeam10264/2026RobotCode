package frc.robot.commands;

 import edu.wpi.first.wpilibj2.command.Command;
 import frc.robot.subsystems.Bshooterwheel;

 public class shooterlong extends Command{
     private final Bshooterwheel m_bshooterHL;   

     public shooterlong(Bshooterwheel ind) {
         m_bshooterHL = ind;
         addRequirements(m_bshooterHL);
     }

      @Override
      public void initialize(){}

     @Override
     public void execute() {
          m_bshooterHL.BshooterwheelRun(m_bshooterHL.shooterwheelBLSpeedLONG);
     }

     @Override
     public void end(boolean interrupted) {
          m_bshooterHL.BshooterwheelStop();
     }

     @Override
     public boolean isFinished() {
         return false;
     }
}