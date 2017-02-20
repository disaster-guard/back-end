package Controller.Repository;

import Pojo.Credentials;
import Pojo.SessionId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<SessionId, String> {
    public Credentials findBySessionId(String sessionId);
}