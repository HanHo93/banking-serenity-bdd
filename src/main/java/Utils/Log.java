package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static Logger log = LogManager.getLogger();
    public static void info(String msg){
        log.info(msg);
    }

    public static void warm(String msg){
        log.warn(msg);
    }

    public static void error(String msg){
        log.error(msg);
    }
}
