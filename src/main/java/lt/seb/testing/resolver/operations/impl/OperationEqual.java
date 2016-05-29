package lt.seb.testing.resolver.operations.impl;

import lt.seb.testing.resolver.operations.Operation;

public class OperationEqual implements Operation<Boolean> {

    public boolean test(Boolean value, Boolean targetValue) {
        return value == targetValue;
    }

}
