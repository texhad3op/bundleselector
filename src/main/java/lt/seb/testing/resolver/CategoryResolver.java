package lt.seb.testing.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lt.seb.testing.resolver.rules.Rule;

public class CategoryResolver<T> {
    List<Rule<T>> rules = new ArrayList<Rule<T>>();

    public CategoryResolver<T> addRule(Rule<T> rule) {
        rules.add(rule);
        return this;
    }

    public Set<T> resolve(Map<String, Object> params) {
        Set<T> types = rules.stream().map(rule -> rule.resolve(params)).filter(type -> null != type)
                .collect(Collectors.toSet());
        return types;
    }

}
