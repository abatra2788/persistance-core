package au.com.anuj.persistance.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import au.com.anuj.persistance.configuration.CorePersistanceConfiguration;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Import(CorePersistanceConfiguration.class)
@Configuration
public @interface EnableCorePersistance {

}
