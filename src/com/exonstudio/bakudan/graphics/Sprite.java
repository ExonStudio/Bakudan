package com.exonstudio.bakudan.graphics;

import com.exonstudio.tools.Time;

public class Sprite {

	private final String name;
	private final int x;
	private final int y;
	private final int w;
	private final int h;

	private boolean animationEnabled = false;
	private int frameDelay = 0;
	private String frameDirection = "";
	private int frameAmount = 0;

	private int currentFrame = 0;
	private long frameTime;

	public Sprite(String name, int x, int y, int w, int h) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.animationEnabled = false;
	}

	public Sprite(String name, int x, int y, int w, int h, String AnimationData) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		if (!(AnimationData == null || AnimationData == ""))
			setAnimationData(AnimationData);
	}

	public void setAnimationData(String animationData) {
		if (animationData.contains("X")) {
			String a[] = animationData.split("X");
			frameDirection = "X";
			frameTime = Time.getTime();
			frameAmount = Integer.parseInt(a[0]);
			frameDelay = Integer.parseInt(a[1]);
			animationEnabled = true;
		} else if (animationData.contains("Y")) {
			String a[] = animationData.split("Y");
			frameDirection = "Y";
			frameTime = Time.getTime();
			frameAmount = Integer.parseInt(a[0]);
			frameDelay = Integer.parseInt(a[1]);
			animationEnabled = true;
		}
	}

	public String getName() {
		return new String(name);
	}

	public int getX() {
		if (animationEnabled && frameDirection == "X") {
			return (currentFrame * w) + x;
		} else {
			return x;
		}
	}

	public int getY() {
		if (animationEnabled && frameDirection == "Y") {
			return (currentFrame * h) + y;
		} else {
			return y;
		}
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		runAnimation();
		return h;
	}

	private void runAnimation() {
		if (Time.getTime() > (frameDelay + frameTime)) {
			if (currentFrame >= frameAmount) {
				currentFrame = 0;
			} else {
				currentFrame++;
			}
			frameTime = Time.getTime();
		}
	}
}
