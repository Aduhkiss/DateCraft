package net.angusbeefgaming.datecraft.managers;

public class DatingManager {
	/*
	 * Created by Atticus Zambrana on 8/16/18
	 */
	private static boolean allowDating = true;
	
	public static boolean isDatingAllowed() {
		return allowDating;
	}
	
	public static void setDatingAllowed(boolean a) {
		allowDating = a;
	}
}
