package au.com.anuj.persistance.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"au.com.anuj.persistance","au.com.anuj.persistance.models"})
public class CorePersistanceConfiguration {
	
}
