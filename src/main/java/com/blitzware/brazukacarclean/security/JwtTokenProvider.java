package com.blitzware.brazukacarclean.security;

import java.nio.charset.Charset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	@SuppressWarnings("deprecation")
	public String generateToken(Authentication authentication) {
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS256, jwtSecret.getBytes(Charset.defaultCharset())).compact();
	}

	@SuppressWarnings("deprecation")
	public String getUserEmail(String token) {
		return Jwts.parser().setSigningKey(jwtSecret.getBytes(Charset.defaultCharset())).parseClaimsJws(token).getBody()
				.getSubject();
	}

	@SuppressWarnings("deprecation")
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret.getBytes(Charset.defaultCharset())).parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
