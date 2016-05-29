package lt.seb.testing.resolver.rules;

import java.util.Map;

import lt.seb.testing.resolver.operations.Operation;

public class RulePart<T> {
    protected String valueName;
    protected Operation<T> operation;
    protected T targetValue;

    public RulePart(String valueName, Operation<T> operation, T targetValue) {
        this.valueName = valueName;
        this.operation = operation;
        this.targetValue = targetValue;
    }

    @SuppressWarnings("unchecked")
    public boolean test(Map<String, Object> params) {
        return operation.test((T)params.get(valueName), targetValue);
    }
}
