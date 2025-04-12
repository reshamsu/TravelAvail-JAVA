// package com.travelavail.travelsystem.controller;

// import com.travelavail.travelsystem.model.Users;
// import com.travelavail.travelsystem.service.UserService;

// // import io.jsonwebtoken.Jwts;
// // import io.jsonwebtoken.SignatureAlgorithm;
// // import io.jsonwebtoken.Claims;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/auth")
// @CrossOrigin(origins = "*", allowedHeaders = "*")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     private String secretKey = "your-secret-key";  // Use a secure key for signing

//     // Login user and return JWT token
//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
//         Users user = userService.authenticateUser(email, password);

//         if (user == null) {
//             return ResponseEntity.status(401).body("Invalid credentials");
//         }

//         // Generate JWT token directly in the controller
//         String token = generateToken(user);

//         Map<String, Object> response = new HashMap<>();
//         response.put("email", user.getEmail());
//         response.put("token", token);

//         return ResponseEntity.ok(response);
//     }

//     // Register user
//     @PostMapping("/register")
//     public ResponseEntity<?> register(@RequestBody Users newUser) {
//         if (userService.userExists(newUser.getEmail())) {
//             return ResponseEntity.status(400).body("Email is already taken");
//         }

//         Users savedUser = userService.createUser(newUser);

//         return ResponseEntity.status(201).body("User registered successfully");
//     }

//     // Logout user (simple invalidation for session or token)
//     @PostMapping("/logout")
//     public ResponseEntity<?> logout() {
//         // For JWT, you can manage token invalidation in frontend (by deleting the token)
//         return ResponseEntity.ok("Logged out successfully");
//     }

//     // Helper method to generate JWT token
//     private String generateToken(Users user) {
//         long now = System.currentTimeMillis();
//         Date expiration = new Date(now + 1000 * 60 * 60);  // Token expires in 1 hour

//         // Create the JWT token
//         return Jwts.builder()
//                 .setSubject(user.getEmail())  // Set email as the subject
//                 .setIssuedAt(new Date(now))
//                 .setExpiration(expiration)
//                 .signWith(SignatureAlgorithm.HS256, secretKey)  // Sign the token with the secret key
//                 .compact();
//     }
// }
