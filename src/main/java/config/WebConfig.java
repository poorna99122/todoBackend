package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	  @Bean
	    public CorsFilter corsFilter() {
	        CorsConfiguration config = new CorsConfiguration();
	        config.addAllowedOrigin("http://localhost:4200"); // Allow your frontend's origin
	        config.addAllowedMethod("*"); // Allow all HTTP methods
	        config.addAllowedHeader("*"); // Allow all headers
	        config.setAllowCredentials(true); // Allow credentials (for Authorization header)

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }

}
