package monkeys;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abdiel
 * Date: 7/2/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Here's an exelent post on how to deal with repositories,
 * how to extende them, how to tune the, and how to work with custom
 * queries on the repositories.
 * http://static.springsource.org/spring-data/commons/docs/current/reference/html/repositories.html
  */
public interface MonkeyRepository extends CrudRepository<Monkey, Long> {
    List<Monkey> findByName(String name);
}