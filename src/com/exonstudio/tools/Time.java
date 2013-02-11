/**
 * 
 */
package com.exonstudio.tools;

import org.lwjgl.Sys;

/**
 * @author Mitchell
 * 
 */
public class Time {

	public static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	public static long calculatePassedTime(long time) {
		return getTime() - time;
	}

}
