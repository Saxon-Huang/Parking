package dbTest;

import org.junit.Test;
import utility.Security;

public class ServiceTest {
    @Test
    public void encoding() {
        String pswd = "123";
        String md5 = Security.md5(pswd);
        System.out.println(md5);
    }
}
