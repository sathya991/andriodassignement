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
      int snailsoutside = 0;
        boolean random;
        mOut.println("There are currently 24 snails in the pen and 0 snails in the pasture");
      for(int i = 0;i < MAX_ITERATIONS-1;i++){
              if(snailsoutside == 0){
                  random = true;
              }
              else if(snailsoutside == 24){
              random = false;
          }else{
                  random = rand.nextBoolean();
              }
              if(random == false){
                   size +=  mWestGate.thru(rand.nextInt(snailsoutside) + 1);
                   snailsoutside = HERD - size;
                  if(snailsoutside == 0){
                      size += mEastGate.thru(rand.nextInt(size)+1);
                      snailsoutside = HERD - size;
                  }
                  mOut.println("There are currently "+size+" snails in the pen and " +snailsoutside+" snails in the pasture");
              }
              else{
                  size += mEastGate.thru(rand.nextInt(size)+1);
                  snailsoutside = HERD - size;
                  if(HERD - size == 0){
                      size += mEastGate.thru(rand.nextInt(size)+1);
                      snailsoutside = HERD - size;
                  }
                  mOut.println("There are currently "+size+" snails in the pen and " +snailsoutside+" snails in the pasture");
              }
          }
        mOut.println("There are currently 24 snails in the pen and 0 snails in the pasture");
    }

}
