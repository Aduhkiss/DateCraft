package net.angusbeefgaming.datecraft.managers;

public class MarrigeManager {
	/*
	 * Created by Atticus Zambrana on 8/16/18
	 */
	private static boolean allowMarrige = true;
	
	public static boolean isMarrigeAllowed() {
		return allowMarrige;
	}
	
	public static void setMarrigeAllowed(boolean a) {
		allowMarrige = a;
	}
}
