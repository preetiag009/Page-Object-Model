package salesForce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jTest {

	public static void main(String[] args) {
		
		Logger logger = LogManager.getLogger(log4jTest.class.getName());
		logger.debug("This is a debug message1");
		logger.info("This is an info message1");
		logger.warn("This is a warn message1");
		logger.error("This is an error message1");
		logger.fatal("This is a fatal message1");
	}
}