package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("repeated")
public interface ModelRepeatedTests {
    @BeforeEach
    default void assignmentForBeforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Now is running " + testInfo.getDisplayName() + " of iteration " + repetitionInfo.getCurrentRepetition() + " !!!");
    }
}
