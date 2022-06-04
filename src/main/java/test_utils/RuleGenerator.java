package test_utils;

import avro_pojos.Rule;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class RuleGenerator {

   public static List<Rule> getRules() {

        Rule warningRule = Rule
                .newBuilder()
                .setRuleId("3")
                .setRuleValue(24)
                .setRuleActiveFlag(true)
                .setRuleAction("TransactionWarning")
                .build();

        Rule denialRule = Rule
                .newBuilder()
                .setRuleId("4")
                .setRuleValue(25)
                .setRuleActiveFlag(true)
                .setRuleAction("TransactionDenial")
                .build();

        Rule preWarningRule = Rule
                .newBuilder()
                .setRuleId("2")
                .setRuleValue(23)
                .setRuleActiveFlag(true)
                .setRuleAction("TransactionPreWarning")
                .build();

        Rule percentageCutOff = Rule
                .newBuilder()
                .setRuleId("1")
                .setRuleValue(90)
                .setRuleActiveFlag(true)
                .setRuleAction("PercentageCutOff")
                .build();

        List<Rule> rules = Lists.newArrayList();
        rules.add(percentageCutOff);
        rules.add(preWarningRule);
        rules.add(denialRule);
        rules.add(warningRule);
        return rules;
    }
}
