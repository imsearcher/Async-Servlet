package com.socket.sample.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketServer extends Thread {
	Logger logger = LoggerFactory.getLogger(SocketServer.class);
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private final static int PORT = 8079;
	private final static long PROCESS_TIME = 60000;

	public SocketServer() {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			logger.error("IOException",e);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				logger.info("waiting...");
				clientSocket = serverSocket.accept();
				PrintStream writer;
				writer = new PrintStream(clientSocket.getOutputStream());
				Thread.sleep(PROCESS_TIME);
				writer.println(new Date());
				writer.flush();

				clientSocket.close();
				logger.info("connection closed...");
			} catch (IOException e) {
				logger.error("IOException", e);
			} catch (InterruptedException e) {
				logger.error("InterruptedException", e);
			}
		}
	}

	public static void main(String[] args) {
		new SocketServer().start();

	}

}
