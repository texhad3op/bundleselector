package lt.seb.testing.services;

import lt.seb.testing.Answer;
import lt.seb.testing.CheckAnswer;
import lt.seb.testing.resolver.types.Bundle;

public interface BundleSelectorService {

    Answer resolveBundle(Integer age, Boolean isStudent, Integer income);

    CheckAnswer checkBundle(Integer age, Boolean isStudent, Integer income, Bundle expectedBundle);

}
