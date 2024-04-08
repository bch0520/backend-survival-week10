package kr.megaptera.backendsurvivalweek10.controllers;

import jakarta.validation.Valid;
import kr.megaptera.backendsurvivalweek10.application.auth.SignupService;
import kr.megaptera.backendsurvivalweek10.dtos.auth.SignupRequestDto;
import kr.megaptera.backendsurvivalweek10.dtos.auth.SignupResultDto;
import kr.megaptera.backendsurvivalweek10.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final SignupService signupService;

    public UserController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SignupResultDto signup(
            @Valid @RequestBody SignupRequestDto signupRequestDto) {
        String accessToken = signupService.signup(
                signupRequestDto.username().trim(),
                signupRequestDto.password().trim());

        return new SignupResultDto(accessToken);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String alreadyExists() {
        return "User Already Exists";
    }
}