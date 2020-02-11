package springApp.Repos;

import org.apache.logging.log4j.message.Message;
import org.springframework.data.repository.CrudRepository;
import springApp.Domain.Messages;

public interface MessageRepo extends CrudRepository<Messages, Integer> {
}
