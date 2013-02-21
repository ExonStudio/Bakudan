/**
 * 
 */
package com.exonstudio.exnet.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.exonstudio.exnet.protocol.ExNetPackage;

/**
 * @author Mitchell
 * 
 */
public class ExNet {

	DatagramSocket connection;
	byte[] data;
	InetAddress address;
	int serverPort;
	byte GameID;

	public ExNet(String serverIP, int serverPort, byte GameID) throws SocketException, UnknownHostException {
		connection = new DatagramSocket();
		data = new byte[256];
		address = InetAddress.getByName(serverIP);
		this.serverPort = serverPort;
		this.GameID = GameID;

		DatagramPacket pack = null;
		data[0] = ExNetPackage.STARTCONNECTION.tobyte();
		pack = new DatagramPacket(data, data.length, address, serverPort);
	}
}
