package lt.seb.testing.resolver.operations.impl;

import lt.seb.testing.resolver.operations.Operation;

public class OperationGreatherThan implements Operation<Integer> {

    public boolean test(Integer value, Integer targetValue) {
        return value > targetValue;
    }

}
