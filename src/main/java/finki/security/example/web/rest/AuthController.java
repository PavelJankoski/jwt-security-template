package finki.security.example.web.rest;

import finki.security.example.domain.enums.ERole;
import finki.security.example.domain.model.Role;
import finki.security.example.domain.model.User;
import finki.security.example.payload.request.LoginRequest;
import finki.security.example.payload.request.SignupRequest;
import finki.security.example.payload.response.JwtResponse;
import finki.security.example.payload.response.MessageResponse;
import finki.security.example.repository.RoleRepository;
import finki.security.example.repository.UserRepository;
import finki.security.example.security.jwt.JwtUtils;
import finki.security.example.service.UserService;
import finki.security.example.service.impl.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(this.userService.signInUser(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if(this.userService.signUpUser(signUpRequest)){
            return ResponseEntity.ok().build();
        }  else{
            return ResponseEntity.badRequest().build();
        }


    }
}
