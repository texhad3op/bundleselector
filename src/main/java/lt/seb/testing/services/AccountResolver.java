package lt.seb.testing.services;

import java.util.Map;
import java.util.Set;

import lt.seb.testing.resolver.types.Account;

public interface AccountResolver {
    Set<Account> resolve(Map<String, Object> params);
}
