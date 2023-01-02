package quest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // Activation des annotations Spring Web : @Controller, @RestController,
				// @RequestMapping, ...
@ComponentScan("quest.web") // On précise dans quel(s) package(s) se situe(nt) les controlleurs
public class WebConfig implements WebMvcConfigurer {

	
}
