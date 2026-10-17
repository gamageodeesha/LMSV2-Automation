
package EstateValuation;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class MainTestEstate {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{
                RealEstateValidationCheck.class,
                AddValuationTest.class,
                EditValuationTest.class,
                ListValuationTest.class

        });
        testng.addListener(tla);
        testng.run();
    }
}
