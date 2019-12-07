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
      int pasture = 0;
      int snailsinside = size + 1;
      int snailsoutside = 0;
        mOut.println("There are currently 24 snails in the pen and 0 snails in the pasture");
      for(int i = 0;i < MAX_ITERATIONS;i++){
              int random = rand.nextInt(2);
              if(pasture == 0 && random == 0){
                  random = 1;
              }
              if(random == 0){
                  if(snailsoutside > 0)
                   size +=  mWestGate.thru(rand.nextInt(snailsoutside));
                  else
                   size+=mWestGate.thru(0);
                  if(size < 24){
                      snailsoutside = HERD - size +1;
                      snailsinside = size + 1;
                      pasture = HERD - size;
                  }
                  else{
                      snailsoutside = HERD - size;
                      snailsinside = size + 1;
                      pasture = HERD - size;
                  }
                  if(pasture == 0){
                      size += mEastGate.thru(rand.nextInt(snailsinside));
                      pasture = HERD - size;
                      snailsinside = size + 1;
                      snailsoutside = HERD - size +1;
                  }
                  mOut.println("There are currently "+size+" snails in the pen and" +pasture+" snails in the pasture");
              }
              else{
                  size += mEastGate.thru(rand.nextInt(snailsinside));
                  pasture = HERD - size;
                  snailsinside = size + 1;
                  snailsoutside = HERD - size +1;
                  if(pasture == 24){
                      size += mWestGate.thru(rand.nextInt(snailsoutside));
                      pasture = HERD - size;
                      snailsinside = size + 1;
                      snailsoutside = HERD - size +1;
                  }
                  mOut.println("There are currently "+size+" snails in the pen and" +pasture+" snails in the pasture");
              }
          }

}
