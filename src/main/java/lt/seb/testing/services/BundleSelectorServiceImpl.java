package lt.seb.testing.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.seb.testing.Answer;
import lt.seb.testing.CheckAnswer;
import lt.seb.testing.Constants;
import lt.seb.testing.resolver.types.Account;
import lt.seb.testing.resolver.types.Bundle;
import lt.seb.testing.resolver.types.Card;

@Service("bundleSelectorService")
public class BundleSelectorServiceImpl implements BundleSelectorService {

    @Autowired
    AccountResolverService accountResolverService;

    @Autowired
    CardResolverService cardResolverService;

    @Autowired
    BundleResolverService bundleResolverService;

    public Answer resolveBundle(Integer age, Boolean isStudent, Integer income) {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put(Constants.AGE_VALUE, age);
        params.put(Constants.IS_STUDENT_VALUE, isStudent);
        params.put(Constants.INCOME_VALUE, income);

        Set<Account> accounts = accountResolverService.resolve(params);
        Set<Card> cards = cardResolverService.resolve(params);
        Bundle bundle = bundleResolverService.resolveBundle(accounts, cards);
        Answer answer = new Answer(age, isStudent, income, bundle);
        return answer;
    }

    public CheckAnswer checkBundle(Integer age, Boolean isStudent, Integer income, Bundle expectedBundle) {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put(Constants.AGE_VALUE, age);
        params.put(Constants.IS_STUDENT_VALUE, isStudent);
        params.put(Constants.INCOME_VALUE, income);

        Set<Account> accounts = accountResolverService.resolve(params);
        Set<Card> cards = cardResolverService.resolve(params);
        Bundle realBundle = bundleResolverService.resolveBundle(accounts, cards);
        Boolean bundleIsCorrect = expectedBundle.equals(realBundle);
        CheckAnswer checkAnswer = new CheckAnswer(age, isStudent, income, expectedBundle, realBundle, bundleIsCorrect);
        return checkAnswer;

    }

    public void setAccountResolverService(AccountResolverService accountResolverService) {
        this.accountResolverService = accountResolverService;
    }

    public void setCardResolverService(CardResolverService cardResolverService) {
        this.cardResolverService = cardResolverService;
    }

    public void setBundleResolverService(BundleResolverService bundleResolverService) {
        this.bundleResolverService = bundleResolverService;
    }

}
