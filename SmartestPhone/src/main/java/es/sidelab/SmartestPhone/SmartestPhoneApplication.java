package es.sidelab.SmartestPhone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class SmartestPhoneApplication {
	
	private static final Log LOG = LogFactory.getLog(SmartestPhoneApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SmartestPhoneApplication.class, args);
	}
	
	@Bean("smartphones")
	public CacheManager cacheManagerSmartphones() {
		LOG.info("Activating cache...");
		return new ConcurrentMapCacheManager("smartphones");
	}
	
}
