package es.iespuertodelacruz.adrian.restaurante.security;

import org.springframework.stereotype.Component;
import org.springframework.web.cors.*;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomCorsFilter extends OncePerRequestFilter {
    private final CorsProcessor processor = new DefaultCorsProcessor();
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        List<String> origins =
                Arrays.asList("http://localhost:3000","http://127.0.0.1:3000");
        config.setAllowedOrigins(origins);
        config.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
        config.setAllowedHeaders(Arrays.asList("authorization", "content-type",
                "x-auth-token"));
        config.addAllowedOriginPattern(CorsConfiguration.ALL);

        source.registerCorsConfiguration("/**", config);
        CorsConfiguration corsConfiguration =
                source.getCorsConfiguration(request);
        boolean isValid = this.processor.processRequest(corsConfiguration,
                request, response);
        if (!isValid || CorsUtils.isPreFlightRequest(request)) {
            return;
        }
        filterChain.doFilter(request, response);
    }
}