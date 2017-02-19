package Controller;

import Pojo.Credentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CredentialsRepository extends MongoRepository<Credentials, String> {
    public Credentials findByEmail(String email);
}