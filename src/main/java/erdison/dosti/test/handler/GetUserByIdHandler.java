package erdison.dosti.test.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import erdison.dosti.test.Dto.UserDto;
import erdison.dosti.test.service.UserService;
import org.springframework.stereotype.Component;

/**
 * A RequestHandler implementation for getting a user by their ID using AWS Lambda.
 *
 * This class handles incoming user ID requests and delegates the user retrieval
 * to the UserService. It is annotated with Spring's @Component to be managed by
 * the Spring framework.
 */
@Component
public class GetUserByIdHandler implements RequestHandler<String, UserDto> {

   private final UserService userService;
  /**
     * Constructor to initialize the handler with a UserService.
     *
     * @param userService The UserService used for retrieving a user by their ID.
     */
    public GetUserByIdHandler(UserService userService) {
        this.userService = userService;
    }
  /**
     * Handles the Lambda function request to get a user by their ID.
     *
     * @param userId   The user ID to be used for retrieval.
     * @param context  The AWS Lambda context.
     * @return A UserDto representing the user with the specified ID.
     */
    @Override
    public UserDto handleRequest(String userId, Context context) {
        return userService.getUserById(userId);
    }
}
