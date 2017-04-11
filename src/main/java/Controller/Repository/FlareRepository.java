package Controller.Repository;

import Pojo.Flare;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlareRepository extends MongoRepository<Flare, String> {
    public Flare findByUserId(String userId);
    public Long removeByUserId(String userId);
}