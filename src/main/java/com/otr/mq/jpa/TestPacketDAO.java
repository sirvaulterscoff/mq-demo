package com.otr.mq.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pobedenniy.alexey
 * @since 28.02.2015
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface TestPacketDAO extends JpaRepository<TestPacket, Long> {
}
