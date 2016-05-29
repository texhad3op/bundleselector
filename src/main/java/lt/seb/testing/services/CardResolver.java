package lt.seb.testing.services;

import java.util.Map;
import java.util.Set;

import lt.seb.testing.resolver.types.Card;

public interface CardResolver {
    Set<Card> resolve(Map<String, Object> params);
}
