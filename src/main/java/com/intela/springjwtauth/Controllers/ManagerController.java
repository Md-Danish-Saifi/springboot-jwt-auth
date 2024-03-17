package com.intela.springjwtauth.Controllers;

import com.intela.springjwtauth.config.JwtAuthFilter;
import com.intela.springjwtauth.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {

    @Autowired
    JwtUtil jwtUtil;
    @GetMapping("/get-token-details")
    public ResponseEntity<?> managerGet(HttpServletRequest request){
        Map<String,Object> data = new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Check if authentication object is not null and is an instance of UserDetails
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            data.put("tokenExpiration",jwtUtil.getExpirationTime(request.getHeader("Authorization")));
            data.put("userInfo",authentication.getPrincipal());
            return ResponseEntity.ok(data);
        }
        return ResponseEntity.badRequest().build();
    }
}
