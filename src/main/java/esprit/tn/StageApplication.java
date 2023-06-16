package esprit.tn;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class StageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StageApplication.class, args);
	}
	

//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setAllowedOrigins(Collections.singletonList(SiteConstants.SITE_ROOT_FRONTEND));
//		corsConfiguration.setAllowedHeaders(List.of(
//				"Origins", "Accept-Control-Allow-Origin", "Content-Type",
//				"Accept", "Jwt-Token", "Authorization", "Origin, Accept",
//				"X-Requested-With", "Access-Control-Request-Method",
//				"Access-Control-Request-Headers"
//		));
//		corsConfiguration.setExposedHeaders(List.of(
//				"Origins", "Accept-Control-Allow-Origin", "Content-Type",
//				"Accept", "Jwt-Token", "Authorization", "Origin, Accept",
//				"X-Requested-With", "Access-Control-Request-Method",
//				"Access-Control-Request-Headers"
//		));
//		corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//		corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//		return new CorsFilter(corsConfigurationSource);
//	}


}
