package lt.seb.testing.services;

import java.util.Set;

import lt.seb.testing.resolver.types.Account;
import lt.seb.testing.resolver.types.Bundle;
import lt.seb.testing.resolver.types.Card;

public interface BundleResolver {

    Bundle resolveBundle(Set<Account> accounts, Set<Card> cards);

}
