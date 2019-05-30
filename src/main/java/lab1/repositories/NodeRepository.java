package lab1.repositories;

import org.springframework.data.repository.CrudRepository;
import lab1.models.Node;

public interface NodeRepository extends CrudRepository<Node, Long> { }
