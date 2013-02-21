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

	DatagramSocket socket;
	byte[] data;
	InetAddress address;
	int serverPort;
	byte GameID;

	public ExNet(String serverIP, int serverPort, byte GameID) throws SocketException, UnknownHostException {
		socket = new DatagramSocket();
		data = new byte[256];
		address = InetAddress.getByName(serverIP);
		this.serverPort = serverPort;
		this.GameID = GameID;

		DatagramPacket pack = null;
		data[0] = ExNetPackage.STARTCONNECTION.tobyte();
		data[1] = GameID;
		pack = new DatagramPacket(data, data.length, address, serverPort);
	}

}
