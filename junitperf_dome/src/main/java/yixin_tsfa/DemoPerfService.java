package yixin_tsfa;
import java.util.UUID;

/**
 * Created by DELL on 2018/8/8.
 */
public class DemoPerfService {

    public String getServiceId(String userId){

        return UUID.randomUUID().toString();
    }
}
