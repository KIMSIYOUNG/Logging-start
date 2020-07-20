import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class MDCExample {
    private static Logger logger = LoggerFactory.getLogger(MDCExample.class);

    public static void main(String[] args) {
        logger.info("Hello MDC");
        MDC.put("userid", "kim");
        MDC.put("event", "order");
        MDC.put("tarnsactionId", "asdasd");
        logger.info("mdc test");

        MDC.clear();
        logger.info("After mdc clear");
    }
}
