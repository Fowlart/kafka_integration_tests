package actions.goldenbook_supplychain.vendor_master;

import actions.goldenbook_supplychain.pojos.VendorRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;

public class SendVendorMasterDev {
    private static final MyKafkaProducer<String, String> producer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOn_STAGE_EnvForStringKeyAndValueWithoutSchema());
    private static final String TOPIC_NAME = "Sephora.SupplyChain.Vendor";
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        VendorRecord record = new VendorRecord();
        record.vendor = 655L;
        record.buyer = 655L;
        record.vendorName = "ARCADE BEAUTY=[15112022-2]";
        record.territory = "US";
        record.cashDiscountPercent = 0D;
        record.cashDiscountDays = 0;
        record.cashDiscountTerms = "N";
        record.cashDiscountNetDays = 30;
        record.firstTradeDiscountPercent = 0D;
        record.secondTradeDiscountPercent = 0D;
        record.thirdTradeDiscountPercent = 0D;
        record.freightAllowancePercent = 0D;
        record.advPromoAllowancePercent = 0D;
        record.purchaseCurrency = "US";
        record.poCostRetailFlag = "R";
        record.ovrEdiXmitFromRetailToCost = "Y";
        record.ovrEdi852FromGrossToNetSales = "Y";
        record.excAdvPromoDiscOnInvoice = "N";
        record.vndInvCostRetail = "C";
        record.brand = 3729L;
        record.brandDescription = "MUGLER THIERRY";
        record.department = 96L;

        String json = objectMapper.writeValueAsString(record);
        System.out.println(json);
        producer.produceRecord("5", json, TOPIC_NAME, 1);
    }
}
