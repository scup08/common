package com.lzh.common.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.lzh.common.model.entity.auth.UserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@ConfigurationProperties( prefix = "jwt")
@PropertySource("classpath:application.properties")
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;
    
    /**
     * 用户名 jwt所面向的用户
     */
//    public static final String CLAIM_KEY_SUB = "sub"; 
    /**
     * 创建时间 jwt的签发时间
     */
//    public static final String CLAIM_KEY_IAT = "iat"; 
    /**
     * 
     */
    public static final String CLAIM_KEY_ROLES = "roles";
    /**
     * jwt签发者
     */
//    public static final String CLAIM_KEY_ISS = "iss";  

    
    //aud: 接收jwt的一方
    /**
     * jwt的过期时间，这个过期时间必须要大于签发时间
     */
//    public static final String CLAIM_KEY_EXP = "exp" ;

    //nbf: 定义在什么时间之前，该jwt都是不可用的.

    /**
     * jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
     */
//    public static final String CLAIM_KEY_JTI = "jti" ;

//    @Value("${jwt.secret}")
//    private String secret;
//    private Long expiration;
//    public String getSecret() {
//		return secret;
//	}

//	public void setSecret(String secret) {
//		this.secret = secret;
//	}

//	@Value("${jwt.expiration}")
    
    
//    @Value("${jwt.tokenHead}")
//    private String tokenHead;
    

//    public String getUsernameFromToken(String token,String secret) {
//        String username;
//        try {
//            final Claims claims = getClaimsFromToken(token,secret);
//            username = claims.getSubject();
//        } catch (Exception e) {
//            username = null;
//        }
//        return username;
//    }
//
//    public Date getCreatedDateFromToken(String token,String secret) {
//        Date created;
//        try {
//            final Claims claims = getClaimsFromToken(token,secret);
//            created = new Date((Long) claims.get(Claims.ISSUED_AT));
//        } catch (Exception e) {
//            created = null;
//        }
//        return created;
//    }

    /**
     * 获取用户信息
     * @param token 
     * @param secret
     * @return
     */
    public static  UserDto getExpirationDateFromToken(String token,String secret) {
    	UserDto userDetails = new UserDto();
    	userDetails.setSecret(secret);
    	userDetails.setToken(token);
    	UserDto user;
        try {
            final Claims claims = getClaimsFromToken(userDetails );
            user = claimsChangeToUser(claims);
//            expiration = claims.getExpiration();
        } catch (Exception e) {
        	user = null;
        }
        return user;
    }
    
    private static UserDto claimsChangeToUser(Claims claims){
    	UserDto user = new UserDto();
    	user.setRoles((List<String>)claims.get("CLAIM_KEY_ROLES"));
    	user.setUsername(claims.getSubject());
    	return user;
    }

    private static Claims getClaimsFromToken(UserDto user) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(user.getSecret())
                    .parseClaimsJws(user.getToken())
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private static Date generateExpirationDate(Long expiration) {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

//    private Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }

//    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
//        return (lastPasswordReset != null && created.before(lastPasswordReset));
//    }

    /**
     * 生成token
     * @param userDetails
     * @return
     */
    public static String  generateToken(UserDto userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.SUBJECT, userDetails.getUsername());
        claims.put(CLAIM_KEY_ROLES, userDetails.getRoles());
        claims.put(Claims.ISSUED_AT, new Date());
        claims.put(Claims.ISSUER,"519370424");
        claims.put(Claims.EXPIRATION, generateExpirationDate(userDetails.getExpiration()));
        return generateToken(claims,userDetails.getSecret());
    }

    private static String generateToken(Map<String, Object> claims,String secret) {
        return Jwts.builder()
                .setClaims(claims)
//                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

//    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
//        final Date created = getCreatedDateFromToken(token);
//        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
//                && !isTokenExpired(token);
//    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public static String refreshToken(String token) {
        String refreshedToken = null;
        try {
//            final Claims claims = getClaimsFromToken(token);
//            claims.put(CLAIM_KEY_CREATED, new Date());
//            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

//	public String getTokenHead() {
//		return tokenHead;
//	}
//
//	public void setTokenHead(String tokenHead) {
//		this.tokenHead = tokenHead;
//	}

//    public Boolean validateToken(String token, UserDetails userDetails) {
//        JwtUser user = (JwtUser) userDetails;
//        final String username = getUsernameFromToken(token);
//        final Date created = getCreatedDateFromToken(token);
//        //final Date expiration = getExpirationDateFromToken(token);
//        return (
//                username.equals(user.getUsername())
//                        && !isTokenExpired(token)
//                        && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
//    }
    
}

