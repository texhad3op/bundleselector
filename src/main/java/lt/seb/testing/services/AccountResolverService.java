package lt.seb.testing.services;

import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lt.seb.testing.Constants;
import lt.seb.testing.resolver.CategoryResolver;
import lt.seb.testing.resolver.operations.impl.OperationEqual;
import lt.seb.testing.resolver.operations.impl.OperationGreatherThan;
import lt.seb.testing.resolver.operations.impl.OperationLessThan;
import lt.seb.testing.resolver.rules.Rule;
import lt.seb.testing.resolver.rules.RulePart;
import lt.seb.testing.resolver.types.Account;

@Service("AccountResolverService")
public class AccountResolverService implements AccountResolver {

    private CategoryResolver<Account> productSetResolver;

    @PostConstruct
    public void init() {
        productSetResolver = new CategoryResolver<Account>();
        productSetResolver.addRule(new Rule<Account>()
                .addRulePart(new RulePart<Integer>(Constants.INCOME_VALUE, new OperationGreatherThan(), 0))
                .addRulePart(new RulePart<Integer>(Constants.AGE_VALUE, new OperationGreatherThan(), 17))
                .expectedCategory(Account.CURRENT_ACCOUNT))

                .addRule(new Rule<Account>()
                        .addRulePart(new RulePart<Integer>(Constants.INCOME_VALUE, new OperationGreatherThan(), 40000))
                        .addRulePart(new RulePart<Integer>(Constants.AGE_VALUE, new OperationGreatherThan(), 17))
                        .expectedCategory(Account.CURRENT_ACCOUNT_PLIUS))

                .addRule(new Rule<Account>()
                        .addRulePart(new RulePart<Integer>(Constants.AGE_VALUE, new OperationLessThan(), 18))
                        .expectedCategory(Account.JUNIOR_SAVER_ACCOUNT))

                .addRule(new Rule<Account>()
                        .addRulePart(new RulePart<Boolean>(Constants.IS_STUDENT_VALUE, new OperationEqual(), true))
                        .addRulePart(new RulePart<Integer>(Constants.AGE_VALUE, new OperationGreatherThan(), 17))
                        .expectedCategory(Account.STUDENT_ACCOUNT));
        ;
    }

    public Set<Account> resolve(Map<String, Object> params) {
        Set<Account> products = productSetResolver.resolve(params);
        if (products.isEmpty())
            products.add(Account.PENSIONER_ACCOUNT);

        return products;

    }
}
