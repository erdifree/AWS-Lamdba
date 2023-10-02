package erdison.dosti.test.DynamoDB.DAO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import erdison.dosti.test.Dto.ResponseDto;
import erdison.dosti.test.Dto.UserDto;
import erdison.dosti.test.DynamoDB.Entity.User;
import org.springframework.stereotype.Repository;
/**
 * Repository class for interacting with the DynamoDB database to manage user data.
 * This class provides methods to save and retrieve user information.
 */
@Repository
public class UserRepository {


    private final DynamoDBMapper dynamoDBMapper;

    public UserRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    /**
     * Save a UserDto to the DynamoDB database.
     *
     * @param user The UserDto to be saved.
     * @return A ResponseDto indicating the result of the save operation.
     */
    public ResponseDto save(UserDto user) {
        dynamoDBMapper.save(user);
        return new ResponseDto(200, "User created successfully");
    }
   /**
     * Retrieve a user by their ID from the DynamoDB database.
     *
     * @param userId The ID of the user to retrieve.
     * @return The User object representing the user with the specified ID.
     */
    public User findById(String userId) {
        return dynamoDBMapper.load(User.class, userId);
    }
}

