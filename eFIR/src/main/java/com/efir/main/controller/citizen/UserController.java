package com.efir.main.controller.citizen;


import com.efir.main.model.User;
import com.efir.main.service.JwtUtil;
import com.efir.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = userService.findByEmailOrMobile(user.getEmail(), user.getMobile())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userService.passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            String token = jwtUtil.generateToken(existingUser.getEmail());
            return ResponseEntity.ok().body(token);
        }
        throw new RuntimeException("Invalid credentials");
    }

    @PostMapping("/sendOtp")
    public ResponseEntity<?> sendOtp(@RequestParam String email) {
        String otp = String.valueOf((int) (Math.random() * 900000) + 100000);
        userService.saveOtp(email, otp);
        // Send OTP via email (implement email service)
        return ResponseEntity.ok().body("OTP sent successfully");
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<?> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        User user = userService.verifyOtp(email, otp);
        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok().body(token);
    }
}