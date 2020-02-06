package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.ComponentScan.Filter;

/**
 * 
 * @author HNN - 4 févr. 2020 23:53:41
 */
@Configuration
@ComponentScan(basePackages = { "spittr" }, 
		excludeFilters = {
				@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
		})
public class RootConfig {

}
