package petstoreapi.karateframework.runner;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class PetStoreRunner {

    @Karate.Test
    Karate testAll(){
        return Karate.run("classpath:features/karatefeatures")
                .tags("@getMultiplePets")
                .relativeTo(getClass());
    }

}
