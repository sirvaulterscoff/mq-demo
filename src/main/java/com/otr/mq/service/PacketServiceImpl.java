package com.otr.mq.service;

import com.otr.mq.jpa.TestPacket;
import com.otr.mq.jpa.TestPacketDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author pobedenniy.alexey
 * @since 28.02.2015
 */
@Service
public class PacketServiceImpl implements PacketService {
	protected static final Logger log = LoggerFactory.getLogger(PacketServiceImpl.class);

	@Autowired
	TestPacketDAO testPacketDAO;

	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void storeNewPacket(String value) {
		log.info("Saving packet with content {}", value);
		TestPacket testPacket = new TestPacket();
		testPacket.setValue(value);
		testPacket = testPacketDAO.save(testPacket);
		log.info("Saved packet with content {} and id {}", value, testPacket.getId());
		log.info("Sending event to queue");
		jmsTemplate.convertAndSend(testPacket);

		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		throw new RuntimeException();
	}
}
