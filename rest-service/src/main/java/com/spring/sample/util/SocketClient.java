package com.spring.sample.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.sample.controller.SpringRestController;

@Service
public class SocketClient {

	Logger logger = LoggerFactory.getLogger(SpringRestController.class);
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
			logger.error("IOException",e);
		}
		return time;
	}
}
