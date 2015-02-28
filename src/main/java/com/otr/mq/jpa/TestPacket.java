package com.otr.mq.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author pobedenniy.alexey
 * @since 28.02.2015
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"id",
		"value",
})
@XmlRootElement(name = "TestPacket")
@Entity
@Table(name = "TEST_PACKET")
public class TestPacket {
	@Id
	@GeneratedValue
	@XmlAttribute
	private long id;

	@Column(length = 50)
	@XmlElement(name = "data")
	private String value;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
