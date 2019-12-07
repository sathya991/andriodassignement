package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
        public static final int OUT = -1;
        public static final int IN = 1;
        public static final int CLOSED = 0;

        private int mSwing;

        public Gate(){
            mSwing = CLOSED;
        }

        //Get Swing Direction
        public int getSwingDirection(){
            return mSwing;
        }
        //Set Swing
        public boolean setSwing(int direction){
            if(direction == CLOSED || direction == OUT || direction == IN){
                mSwing = direction;
                return true;
            }
            else{
                return false;
            }
        }
        //Open
        public boolean open(int direction){
            if(direction == IN || direction == OUT){
                setSwing(direction);
                return true;
            }
            else {
                return false;
            }
        }
        //Close
        public void close(){
            mSwing = CLOSED;
        }
        //Thru
        public int thru(int count){
            return mSwing*count;
        }

        public String toString(){
            // a gate that is closed
            if(mSwing == CLOSED){
                return  String.format("This gate is closed");
            }
            // a gate that has opened to swing IN
            if(mSwing == IN){
                return String.format("This gate is open and swings to enter the pen only");
            }
            // a gate that been opened swing OUT
            if(mSwing == OUT){
                return String.format("This gate is open and swings to exit the pen only");
            }
            // a gate that has a swing value other than IN, OUT, or CLOSED
            else {
                return String.format("This gate has an invalid swing direction");
            }

        }
}
