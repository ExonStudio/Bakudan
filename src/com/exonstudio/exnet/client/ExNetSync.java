/**
 * 
 */
package com.exonstudio.exnet.client;

/**
 * @author Mitchell
 * 
 */
public interface ExNetSync {

	public void netSetData(ExNetData data);

	public ExNetData netGetData();

	public void netDestroy();

}
