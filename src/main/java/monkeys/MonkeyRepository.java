package monkeys;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * MIT License
 *
 * @author abdiel
 */

/**
 * Here's an excellent guide on how to deal with repositories,
 * how to extend them, how to tune the, and how to work with custom
 * queries on the repositories.
 * http://static.springsource.org/spring-data/commons/docs/current/reference/html/repositories.html
  */
public interface MonkeyRepository extends CrudRepository<Monkey, Long> {
    List<Monkey> findByName(String name);
}