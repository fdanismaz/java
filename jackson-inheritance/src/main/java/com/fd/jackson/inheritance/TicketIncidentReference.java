package com.fd.jackson.inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 * @author fdanismaz
 * date: 3/11/19 8:15 PM
 */
@Getter
@Setter
public class TicketIncidentReference implements TicketReference {

	private String incidentId;
	private String incidentName;
}
