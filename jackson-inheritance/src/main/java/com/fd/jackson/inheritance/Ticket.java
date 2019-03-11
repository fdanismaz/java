package com.fd.jackson.inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 * @author fdanismaz
 * date: 3/11/19 8:18 PM
 */
@Getter
@Setter
public class Ticket {
	private String title;
	private TicketReferences references;
}
