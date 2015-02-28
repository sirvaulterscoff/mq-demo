package com.otr.mq.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * TODO: comment
 * @author pobedenniy.alexey
 * @since 28.02.2015
 */
public interface PacketService {

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	void storeNewPacket(String value);
}
