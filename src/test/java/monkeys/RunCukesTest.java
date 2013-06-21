package monkeys;

/**
 * MIT License
 * Date: 6/19/13
 * Time: 5:08 PM
 *
 * @author abdiel
 */
import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber"})
public class RunCukesTest {
}
