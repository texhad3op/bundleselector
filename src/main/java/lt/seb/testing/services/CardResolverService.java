package lt.seb.testing.services;

import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lt.seb.testing.Constants;
import lt.seb.testing.resolver.CategoryResolver;
import lt.seb.testing.resolver.operations.impl.OperationEqual;
import lt.seb.testing.resolver.operations.impl.OperationGreatherThan;
import lt.seb.testing.resolver.rules.Rule;
import lt.seb.testing.resolver.rules.RulePart;
import lt.seb.testing.resolver.types.Card;

@Service("cardResolverService")
public class CardResolverService implements CardResolver {

    private CategoryResolver<Card> productSetResolver;

    @PostConstruct
    public void init() {
        productSetResolver = new CategoryResolver<Card>();
        productSetResolver.addRule(new Rule<Card>()
                .addRulePart(new RulePart<Integer>(Constants.INCOME_VALUE, new OperationGreatherThan(), 0))
                .addRulePart(new RulePart<Integer>(Constants.AGE_VALUE, new OperationGreatherThan(), 17))
                .expectedCategory(Card.DEBIT_CARD))

                .addRule(new Rule<Card>()
                        .addRulePart(new RulePart<Integer>(Constants.INCOME_VALUE, new OperationGreatherThan(), 40000))
                        .addRulePart(new RulePart<Integer>(Constants.AGE_VALUE, new OperationGreatherThan(), 17))
                        .expectedCategory(Card.DEBIT_CARD))

                .addRule(new Rule<Card>()
                        .addRulePart(new RulePart<Boolean>(Constants.IS_STUDENT_VALUE, new OperationEqual(), true))
                        .addRulePart(new RulePart<Integer>(Constants.AGE_VALUE, new OperationGreatherThan(), 17))
                        .expectedCategory(Card.DEBIT_CARD))

                .addRule(new Rule<Card>()
                        .addRulePart(new RulePart<Integer>(Constants.INCOME_VALUE, new OperationGreatherThan(), 12000))
                        .addRulePart(new RulePart<Integer>(Constants.AGE_VALUE, new OperationGreatherThan(), 17))
                        .expectedCategory(Card.CREDIT_CARD))

                .addRule(new Rule<Card>()
                        .addRulePart(new RulePart<Integer>(Constants.INCOME_VALUE, new OperationGreatherThan(), 40000))
                        .addRulePart(new RulePart<Integer>(Constants.AGE_VALUE, new OperationGreatherThan(), 17))
                        .expectedCategory(Card.GOLD_CREDIT_CARD));
    }

    public Set<Card> resolve(Map<String, Object> params) {

        Set<Card> cards = productSetResolver.resolve(params);
        if (cards.isEmpty())
            cards.add(Card.DEBIT_CARD);

        return cards;

    }
}
