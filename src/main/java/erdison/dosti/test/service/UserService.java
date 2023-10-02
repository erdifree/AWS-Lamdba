package erdison.dosti.test.service;

import erdison.dosti.test.Dto.ResponseDto;
import erdison.dosti.test.Dto.UserDto;
import erdison.dosti.test.DynamoDB.DAO.UserRepository;
import erdison.dosti.test.DynamoDB.Entity.User;
import org.springframework.stereotype.Service;


/**
 * The UserService class provides methods for managing user data and interactions.
 *
 * This class encapsulates user-related functionality and interacts with a UserRepository
 * for data persistence and retrieval.
 */
@Service
public class UserService {


    private final UserRepository userRepository;

    /**
     * Constructs a new UserService with the provided UserRepository.
     *
     * @param userRepository The UserRepository used for data storage and retrieval.
     */

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Creates a new user using the provided user data.
     *
     * @param user The UserDto containing user information to be created.
     * @return A ResponseDto indicating the result of the user creation operation.
     */
    public ResponseDto createUser(UserDto user) {
        return userRepository.save(user);
    }


    /**
     * Retrieves a user by their unique identifier (userId).
     *
     * @param userId The unique identifier of the user to retrieve.
     * @return A UserDto containing user information if found, or null if not found.
     */
    public UserDto getUserById(String userId) {
        User  user = userRepository.findById(userId);
        return new UserDto(user.getUserId(), user.getUsername(), user.getEmail());
    }
}
