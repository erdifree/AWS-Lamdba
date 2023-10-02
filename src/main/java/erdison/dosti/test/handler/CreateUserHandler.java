package erdison.dosti.test.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import erdison.dosti.test.Dto.ResponseDto;
import erdison.dosti.test.Dto.UserDto;
import erdison.dosti.test.service.UserService;
import org.springframework.stereotype.Component;


/**
 * A RequestHandler implementation for creating a user using AWS Lambda.
 *
 * This class handles incoming UserDto requests and delegates the user creation
 * to the UserService. It is annotated with Spring's @Component to be managed by
 * the Spring framework.
 */
@Component
public class CreateUserHandler implements RequestHandler<UserDto, ResponseDto> {
    private final UserService userService;
  /**
     * Constructor to initialize the handler with a UserService.
     *
     * @param userService The UserService used for user creation.
     */
    public CreateUserHandler(UserService userService) {
        this.userService = userService;
    }

 /**
     * Handles the Lambda function request to create a user.
     *
     * @param userDto  The UserDto containing user information to be created.
     * @param context  The AWS Lambda context.
     * @return A ResponseDto indicating the result of the user creation.
     */
    @Override
    public ResponseDto handleRequest(UserDto userDto, Context context) {
        return userService.createUser(userDto);
    }

}


