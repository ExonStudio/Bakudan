/**
 * 
 */
package com.exonstudio.exnet.protocol;

/**
 * @author Mitchell
 * 
 */
public enum ExNetPackage {
	STARTCONNECTION,
	SENDGAMEID,
	WELCOME;

	public byte tobyte() {
		return (byte) this.ordinal();
	}
}
