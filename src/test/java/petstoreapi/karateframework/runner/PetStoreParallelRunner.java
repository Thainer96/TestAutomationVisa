package petstoreapi.karateframework.runner;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetStoreParallelRunner {
     private final static int WORKERS = 5;
    @Test
    void testParallel() {
        Results results = Runner.path("classpath:features/karatefeatures").tags("regression")
                .parallel(WORKERS);
        assertTrue(results.getFailCount() == 0, results.getErrorMessages());
    }

}
