package net.angusbeefgaming.datecraft.util;

import org.bukkit.entity.Player;


public class MathUtil {
	public static double distance(Player p1, Player p2) {
		int pl1X = (int) p1.getLocation().getX();
		int pl1Z = (int) p1.getLocation().getZ();
		
		int pl2X = (int) p2.getLocation().getX();
		int pl2Z = (int) p2.getLocation().getZ();
		
		int hold1 = pl1Z - pl2Z;
		int hold2 = pl1X - pl2X;
		
		int hold3 = (int) squareNum(hold1);
		int hold4 = (int) squareNum(hold2);
		
		int number = hold3 + hold4;
		
		return Math.sqrt(number);
	}
	
	public static double squareNum(int x) {
		return (x * x);
	}
}
