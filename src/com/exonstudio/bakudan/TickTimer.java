package com.exonstudio.bakudan;

import com.exonstudio.tools.Time;

public class TickTimer {

	int fps;
	long lastFrame;
	long lastTick;
	long lastFPS;

	public TickTimer() {

	}

	public void start() {
		lastFPS = Time.getTime();
		getTickDuration();
	}

	public void tick() {
		int delta = getTickDuration();
		tick(delta);
	}

	public void tick(int delta) {
		updateFPS();
	}

	public void updateFPS() {
		if (Time.getTime() - lastFPS > 1000) {
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public int getTickDuration() {
		long time = Time.getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}
}
