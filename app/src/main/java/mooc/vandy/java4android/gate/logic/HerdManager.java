package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Constructor initializes the fields.
     */
    public static final int HERD = 24;
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }
    public void simulateHerd(Random rand){
      int size = HERD;
      int snailsinside = size + 1;
      int snailsoutside = 0;
//        while(size >= 0 && size<= HERD){
      for(int i = 0;i < MAX_ITERATIONS;i++){
              int random = rand.nextInt(2);
              if(random == 0){
                  size +=  mWestGate.thru(rand.nextInt(snailsoutside));
                  if(size < 24){
                      snailsoutside = HERD - size +1;
                      snailsinside = size + 1;
                  }
                  else{
                      snailsoutside = HERD - size;
                  }
                  mOut.println("There are currently "+size+" snails in the pen and "+ (HERD-size) +" snails in the pasture");
              }
              else{
                  size -= mEastGate.thru(rand.nextInt(snailsinside));
                  snailsinside = size + 1;
                  snailsoutside = HERD - size +1;
                  mOut.println("There are currently "+size+" snails in the pen and "+ (HERD-size) +" snails in the pasture");
              }
          }
      //}
    }
    // TODO -- Fill your code in here


}
