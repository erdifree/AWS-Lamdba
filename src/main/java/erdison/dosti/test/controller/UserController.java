package erdison.dosti.test.controller;

import erdison.dosti.test.Dto.ResponseDto;
import erdison.dosti.test.Dto.UserDto;
import erdison.dosti.test.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }


    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        return userService.getUserById(userId);
    }
}