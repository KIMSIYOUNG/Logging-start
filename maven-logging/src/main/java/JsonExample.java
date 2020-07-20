import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExample {
    private static Logger logger = LoggerFactory.getLogger(JsonExample.class);

    public static void main(String[] args) throws JsonProcessingException {
        Map<String, String> map = new TreeMap();
        map.put("name", "kyle");
        map.put("email","kyle@gmail.com");
        String messages = new ObjectMapper().writeValueAsString(map);
        System.out.println(messages);
        logger.info(messages);
    }
}
