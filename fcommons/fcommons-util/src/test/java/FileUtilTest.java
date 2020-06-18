import com.fcommons.util.FileUtil;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * @author fdanismaz
 * @since 6/18/20
 */
public class FileUtilTest {

    @Test
    public void testGetResourceAsStream() throws FileNotFoundException {
        String content = FileUtil.readResource("files/testfile");
        System.out.println(content);
    }
}
