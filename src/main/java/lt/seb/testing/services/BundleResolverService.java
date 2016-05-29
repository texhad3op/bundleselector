package lt.seb.testing.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lt.seb.testing.comparators.BundleComparator;
import lt.seb.testing.resolver.types.Account;
import lt.seb.testing.resolver.types.Bundle;
import lt.seb.testing.resolver.types.Card;

@Service("bundleResolverService")
public class BundleResolverService implements BundleResolver {

    private Map<Bundle, Set<Enum<?>>> bundles = new HashMap<Bundle, Set<Enum<?>>>();

    @PostConstruct
    public void init() {
        bundles.put(Bundle.JUNIOR_SAVER, new HashSet<Enum<?>>(Arrays.asList(Account.JUNIOR_SAVER_ACCOUNT)));
        bundles.put(Bundle.STUDENT,
                new HashSet<Enum<?>>(Arrays.asList(Account.STUDENT_ACCOUNT, Card.CREDIT_CARD, Card.DEBIT_CARD)));
        bundles.put(Bundle.CLASSIC, new HashSet<Enum<?>>(Arrays.asList(Account.CURRENT_ACCOUNT, Card.DEBIT_CARD)));
        bundles.put(Bundle.CLASSIC_PLUS,
                new HashSet<Enum<?>>(Arrays.asList(Account.CURRENT_ACCOUNT, Card.CREDIT_CARD, Card.DEBIT_CARD)));
        bundles.put(Bundle.GOLD, new HashSet<Enum<?>>(
                Arrays.asList(Account.CURRENT_ACCOUNT_PLIUS, Card.DEBIT_CARD, Card.GOLD_CREDIT_CARD)));
    }

    public Bundle resolveBundle(Set<Account> accounts, Set<Card> cards) {
        HashSet<Enum<?>> preparedData = prepareData(accounts, cards);
        Bundle bundle = removeNotAppropriatedBundles(preparedData);
        return bundle;
    }

    private HashSet<Enum<?>> prepareData(Set<Account> accounts, Set<Card> cards) {
        HashSet<Enum<?>> preparedData = new HashSet<Enum<?>>();
        preparedData.addAll(accounts);
        preparedData.addAll(cards);
        return preparedData;
    }

    private Bundle removeNotAppropriatedBundles(HashSet<Enum<?>> preparedData) {
        List<Bundle> selectedBundles = new ArrayList<Bundle>();

        bundles.forEach((k, v) -> {
            Boolean bundleIsAppropriate = preparedData.containsAll(v);
            if (bundleIsAppropriate)
                selectedBundles.add(k);
        });

        Collections.sort(selectedBundles, new BundleComparator());
        Bundle bundle = selectedBundles.stream().findFirst().orElse(Bundle.NO_BUNDLE);
        return bundle;
    }

}
