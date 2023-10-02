package erdison.dosti.test.DynamoDB.Config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up and configuring the AWS DynamoDB client and DynamoDBMapper.
 */

@Configuration
@EnableDynamoDBRepositories
        (basePackages = "erdison.dosti.test.DynamoDB.DAO")
public class DynamoDBConfig {



    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;
    @Value("${amazon.dynamodb.region}")
    private String region;

    /**
     * Create and configure an Amazon DynamoDB client.
     *
     * @return The configured AmazonDynamoDB client.
     */

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClient.builder()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey)))
                .withRegion(region)
                .build();
    }

     /**
     * Create and configure a DynamoDBMapper, which simplifies interaction with DynamoDB.
     *
     * @return The configured DynamoDBMapper.
     */
    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(amazonDynamoDB());
    }


}