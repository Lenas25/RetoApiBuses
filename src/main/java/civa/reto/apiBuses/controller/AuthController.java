package civa.reto.apiBuses.controller;

import civa.reto.apiBuses.dto.LoginData;
import civa.reto.apiBuses.model.Auth;
import civa.reto.apiBuses.repository.AuthRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final AuthRepository authRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginData loginRequest) {
        // Busca el usuario en la base de datos
        Auth user = authRepository.findByUsername(loginRequest.username())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Compara la contraseña proporcionada con la almacenada en la base de datos
        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw new BadCredentialsException("Credenciales incorrectas");
        }

        String secretKeyBase64 = System.getenv("JWT_SECRET");
        SecretKey secretKey = new SecretKeySpec(Base64.getDecoder().decode(secretKeyBase64), SignatureAlgorithm.HS512.getJcaName());

        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000))
                .signWith(secretKey)
                .compact();
        System.out.println("Token: " + token);

        long expiresIn = System.currentTimeMillis() + 2 * 60 * 60 * 1000;

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("expiresIn", expiresIn);

        return ResponseEntity.ok(response);
    }



}