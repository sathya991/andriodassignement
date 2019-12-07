package mooc.vandy.java4android.gate.logic;

import android.util.Log;

import java.util.Arrays;
import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here
  public void setCorralGates(Gate[]gate,Random selectDirection){
      for(int i = 0;i< gate.length;i++){
          int gatedirection = selectDirection.nextInt(3)-1;
          if(gatedirection == 0){
              gate[i].setSwing(0);
              mOut.println("Gate "+ i +": This gate is closed");
          }
          else if(gatedirection == 1){
              gate[i].setSwing(1);
              mOut.println("Gate "+ i +": This gate is Open and swings to enter the pen only");
          }
          else {
              gate[i].setSwing(-1);
              mOut.println("Gate "+ i +": This gate is Open and swings to exit the pen only");
          }
      }
//      mOut.println(Arrays.toString(gate));
  }
    public boolean anyCorralAvailable(Gate[] corral){
      for(int i = 0; i< corral.length; i++){
         if(corral[i].getSwingDirection() == 1){
             return true;
         }
      }
      Random random = new Random();
      setCorralGates(corral,random);
      return false;
    }
    public int corralSnails(Gate[]corral,Random rand){
        int pasture = 5;
        int count = 0;
        int random = rand.nextInt(pasture + 1);
        while(pasture > 0){
        for(int i = 0;i < corral.length;i++){
               if(corral[i].getSwingDirection() == 1){
                   pasture = pasture - random;
                   count++;
                   //Log.i("something",corral[i].toString());
                   mOut.println(random + " are trying to move through corral "+ i);
               }
               else if(corral[i].getSwingDirection() == 0){
                   pasture = pasture+random;
                   count++;
                   mOut.println(random + " are trying to move out of corral "+ i);
               }
               else{
                   count++;
                   mOut.println("0 are trying to move out of the corral "+ i);
               }
           }
        }
     mOut.println("It took "+ count + " attempts to corral all of the snails.");
    return count;
    }
}
