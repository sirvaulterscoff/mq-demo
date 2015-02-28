package com.otr.mq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

/**
 * @author pobedenniy.alexey
 * @since 28.02.2015
 */
@Service("jmsListenerService")
public class JmsListenerService {
	protected static final Logger log = LoggerFactory.getLogger(JmsListenerService.class);


	@Transactional
	public void handleMessage(Object in) {
		log.info("Received new message {}", in);
	}
}
