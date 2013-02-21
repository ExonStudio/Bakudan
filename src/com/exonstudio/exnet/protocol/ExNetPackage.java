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
	WELCOME;

	public byte tobyte() {
		return (byte) this.ordinal();
	}
}
