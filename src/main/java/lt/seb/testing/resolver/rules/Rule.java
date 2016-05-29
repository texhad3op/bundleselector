package lt.seb.testing.resolver.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rule<T> {
    protected List<RulePart<?>> ruleParts = new ArrayList<RulePart<?>>();
    protected T type;

    public Rule<T> addRulePart(RulePart<?> rulePart) {
        ruleParts.add(rulePart);
        return this;
    }

    public Rule<T> expectedCategory(T type) {
        this.type = type;
        return this;
    }

    public T resolve(Map<String, Object> params) {
        return true == ruleParts.stream().allMatch(rule -> rule.test(params)) ? type : null;
    }

}
