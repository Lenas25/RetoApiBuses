package civa.reto.apiBuses.security;

import civa.reto.apiBuses.model.Auth;
import civa.reto.apiBuses.repository.AuthRepository;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private AuthRepository authRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }


        String token = header.replace("Bearer ", "");
        try {
            String username = Jwts.parser()
                    .setSigningKey(System.getenv("JWT_SECRET"))
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            System.out.println(username);
            System.out.printf(token);

            if (username != null) {

                Auth user = authRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(user.getUsername(), null, List.of());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token inválido o expirado");
            return;
        }
        chain.doFilter(request, response);
    }
}

