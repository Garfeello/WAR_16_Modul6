package pl.coderslab.Spring01hibernate.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { SimpleSampleTest.class, SimpleSample2Test.class } )
public class TestSuite {
}
