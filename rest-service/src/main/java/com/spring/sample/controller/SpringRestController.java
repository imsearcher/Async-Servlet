package com.spring.sample.controller;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sample.util.SocketClient;
import com.spring.sample.util.MessageVO;

@RestController
@RequestMapping("/hello")
public class SpringRestController {

	Logger logger = LoggerFactory.getLogger(SpringRestController.class);
	@Autowired
	SocketClient socketClient;

	@Async
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public Callable<MessageVO> hello() {
		logger.info("entering...");
		Callable<MessageVO> asyncTask = new Callable<MessageVO>() {

			@Override
			public MessageVO call() throws Exception {
				return new MessageVO(socketClient.getMSG());
			}
		};
		logger.info("leaving...");
		return asyncTask;
	}

}
