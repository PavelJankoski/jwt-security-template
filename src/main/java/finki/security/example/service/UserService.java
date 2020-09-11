package finki.security.example.service;

import finki.security.example.payload.request.LoginRequest;
import finki.security.example.payload.request.SignupRequest;
import finki.security.example.payload.response.JwtResponse;

public interface UserService {
    JwtResponse signInUser(LoginRequest loginRequest);
    boolean signUpUser(SignupRequest signupRequest);
}
