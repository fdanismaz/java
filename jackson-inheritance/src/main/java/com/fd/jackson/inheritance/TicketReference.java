package com.fd.jackson.inheritance;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author fdanismaz
 * date: 3/11/19 8:15 PM
 */
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = TicketIncidentReference.class, name = "incident")
})
public interface TicketReference {
}
