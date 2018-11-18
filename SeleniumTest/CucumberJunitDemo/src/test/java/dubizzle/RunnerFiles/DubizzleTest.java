package dubizzle.RunnerFiles;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/resources/features/dubizzle.feature",
        glue = {"dubizzle"},
        tags = {"@Dubizzle_TC_01"},
        format = {"pretty", "html:target/html_report/Dubizzle_TC_01/"}
)
public class DubizzleTest {
}