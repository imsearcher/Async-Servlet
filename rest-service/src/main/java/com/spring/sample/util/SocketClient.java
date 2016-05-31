package com.spring.sample.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.springframework.stereotype.Service;

@Service
public class SocketClient {

	
	private final static String IP="127.0.0.1";
	private final static int PORT=8079;
	
	public String getMSG() {
		String time = "";
		try {
			Socket clientSocket = new Socket(IP, PORT);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			time = reader.readLine();
			clientSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return time;
	}
}
