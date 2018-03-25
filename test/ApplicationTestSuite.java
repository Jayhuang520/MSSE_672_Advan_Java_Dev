import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.huangshotelreservation.model.business.AllBusinessTests;
import com.huangshotelreservation.model.domain.AllDomainTests;
import com.huangshotelreservation.model.services.AllServiceTests;

@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class,
	AllServiceTests.class,AllDomainTests.class})
public class ApplicationTestSuite {

}
