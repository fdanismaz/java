import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fd.jackson.inheritance.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author fdanismaz
 * date: 3/11/19 8:05 PM
 */
public class JacksonInheritanceTest {

	@Test
	public void testTicketReferenceSerialization() throws IOException {
		TicketReferences references = new TicketReferences();
		List<TicketReference> referenceList = new ArrayList<>();
		TicketIncidentReference incidentReference = new TicketIncidentReference();
		incidentReference.setIncidentId("1");
		incidentReference.setIncidentName("incident-1");
		referenceList.add(incidentReference);
		references.setReferences(referenceList);

		Ticket ticket = new Ticket();
		ticket.setReferences(references);
		ticket.setTitle("Ticket-1");

		Resource<Ticket> r = new Resource<>();
		r.setContent(ticket);

		RestApiResponseBody<Resource<Ticket>> rarb = new RestApiResponseBody<>();
		rarb.setBody(r);

		ObjectMapper mapper = new ObjectMapper();
		String jsonDataString = mapper.writeValueAsString(rarb);

		System.out.println(jsonDataString);

		RestApiResponseBody<Resource<Ticket>> parsedResponse = mapper.readValue(jsonDataString, new TypeReference<RestApiResponseBody<Resource<Ticket>>>() {});
		Ticket parsedTicket = parsedResponse.getBody().getContent();

		assertEquals("Ticket-1", parsedTicket.getTitle());
		assertEquals(1, parsedTicket.getReferences().getReferences().size());
		assertEquals("incident-1", ((TicketIncidentReference)(parsedTicket.getReferences().getReferences().get(0))).getIncidentName());
	}
}
