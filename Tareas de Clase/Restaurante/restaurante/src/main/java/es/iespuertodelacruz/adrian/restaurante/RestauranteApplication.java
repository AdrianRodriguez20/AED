package es.iespuertodelacruz.adrian.restaurante;


import es.iespuertodelacruz.adrian.restaurante.security.CustomCorsFilter;
import es.iespuertodelacruz.adrian.restaurante.security.FiltroJWT;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@SpringBootApplication
public class RestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}

	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		public void configure(WebSecurity webSecurity) throws Exception
		{
			webSecurity
					.ignoring()
					.antMatchers(HttpMethod.POST, "/api/login")
					.antMatchers(HttpMethod.POST, "/api/registro")
					.antMatchers("/api/v1/**");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
			http
					.addFilterBefore(new CustomCorsFilter(),
						WebAsyncManagerIntegrationFilter.class)
					.csrf().disable()
					.addFilterBefore(new FiltroJWT(),
							UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.requestMatchers(CorsUtils::isCorsRequest).permitAll()
					.antMatchers(HttpMethod.OPTIONS, "**").permitAll()
					.antMatchers("/api/v2/**").hasRole("USER")
					.anyRequest().authenticated()
			;

			http.exceptionHandling()
					.authenticationEntryPoint((request, response, e) ->
					{

						response.setContentType("application/json;charset=UTF-8");
						response.setStatus(HttpServletResponse.SC_FORBIDDEN);
						response.getWriter().write(new JSONObject()
								.put("timestamp", LocalDateTime.now())
								.put("message", "token no correctamente autenticado")
								.toString());
					});
		}
	}
}
