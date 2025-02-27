package com.guilherme.alves.app_teste_springboot3.security;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
    /**
     * 
     * OBS: Tive que alterar implementação original do curso com
     * SignatureAlgorithm.HS256 para uma chave fixa
     * porque ao salvar o arquivo de requisições com o novo token gerado, a
     * aplicação era recarregada e invalidava
     * o token gerado. Já que a implementação gera uma chave para compor o Token
     * sempre que inicializado!
     * 
     */
    private static final String CHAVE = "aW91d2VyZWNvbXBsZXRlbHlzY3Jld2Vkd2hlbnlvdWRlY29kZWR0aGlz";
    private static final Key key = Keys.hmacShaKeyFor(CHAVE.getBytes());
    // private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000; // Representa 1 dia em ms

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                // .signWith(key, SignatureAlgorithm.HS256)
                .signWith(key)
                .compact();
    }

    public static String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
