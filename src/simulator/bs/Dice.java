package simulator.bs;

import java.util.Random;

@SuppressWarnings("serial")
public class Dice extends Random {
	
	private static Random rand;
	
	public static int roll(int min, int max){
		if(min >= max){
			throw new DiceMinMaxException("Minimum must be less than maximum: " + min + " > " + max);
		}
		rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
	
	/**
	 * Calls the roll(min, max) method with 1 as the minimum.  Can be used
	 * to make code look cleaner.  If you need to be between a certain range
	 * then use the other roll method.
	 * @param max An integer that is the maximum value the dice can be. For
	 * instance, in a d6, the value 6 is the maximum.
	 * @return The value that was rolled.  This is randomly generated using the
	 * Random class.
	 */
	public static int roll(int max){
		return roll(1, max);
	}
}

@SuppressWarnings("serial")
class DiceMinMaxException extends RuntimeException{
	public DiceMinMaxException(){
		super();
	}
	
	public DiceMinMaxException(String message){
		super(message);
	}
	
	public DiceMinMaxException(String message, Throwable cause){
		super(message, cause);
	}
	
	public DiceMinMaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public DiceMinMaxException(Throwable cause){
		super(cause);
	}
}
