package com.otr.mq.rest;

import com.otr.mq.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author pobedenniy.alexey
 * @since 28.02.2015
 */
@RestController
public class TestController {
	@Autowired
	PacketService packetService;

	@RequestMapping("/")
	public String index() {
		packetService.storeNewPacket(String.valueOf(UUID.randomUUID()));
		return "Greetings from Spring Boot!";
	}
}
