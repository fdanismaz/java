import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fd.jackson.bidirectional.model.Item;
import com.fd.jackson.bidirectional.model.User;
import org.testng.annotations.Test;

public class BidirectionalMappingTest {

    @Test //(expectedExceptions = JsonMappingException.class)
    public void givenBidirectionRelation_whenSerializingItem_thenException()
            throws JsonProcessingException {

        User user = new User(1, "John");
        Item item = new Item(2, "book", user);
        user.addItem(item);

        System.out.println(new ObjectMapper().writeValueAsString(item));
    }

    @Test //(expectedExceptions = JsonMappingException.class)
    public void givenBidirectionRelation_whenSerializingUser_thenException()
            throws JsonProcessingException {

        User user = new User(1, "John");
        Item item = new Item(2, "book", user);
        user.addItem(item);

        System.out.println(new ObjectMapper().writeValueAsString(user));
    }

}
