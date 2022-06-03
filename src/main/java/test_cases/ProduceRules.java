package test_cases;

import avro_pojos.Rule;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class ProduceRules {

    /** ('1',2,90,'Percentage cut off','PercentageCutOff',true, unix_timestamp(), unix_timestamp()),

     ('2',1,23,'Pre-Warning # of transactions','TransactionPreWarning',true, unix_timestamp(), unix_timestamp()),

     ('4',4,25,'Denial # of transactions','TransactionDenial',true, unix_timestamp(), unix_timestamp()),

     ('3',3,24,'Warning # of transactions','TransactionWarning',true, unix_timestamp(), unix_timestamp());
     */

    private static final MyKafkaProducer<String, Rule> ruleProducer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer());

   static private List<Rule> getRules() {

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

    public static void main(String[] args) {
       getRules().forEach(rule ->
               ruleProducer.produceRecord(rule.getRuleId(),rule,
                       "Sephora.DataPlatform.ReturnAuth.RulesManage",1));
    }
}
