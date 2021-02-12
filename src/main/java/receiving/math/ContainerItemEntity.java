package receiving.math;

import java.time.LocalDate;
import java.util.StringJoiner;

public class ContainerItemEntity {
    private String uid;
    private String accountId;
    private String caseQty;
    private String damagedQty;
    private String expirationDate;
    private String fillDcId;
    private String fillItem;
    private String fillUnitPrice;
    private String fillUomCode;
    private String invoicedQty;
    private String itemDescription;
    private String itemNo;
    private String lotNumber;
    private String ndc;
    private String ovrShrtQuantity;
    private String purchaseOrderNumber;
    private String quantity;
    private String receivedQty;
    private String receivedDeltaQty;
    private String seqLineNumber;
    private String tenDigitNdc;
    private String upc;
    private String receivedDescInd;
    private String imgSmall;
    private String imgLarge;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private String orderId;
    private String drgEoeOrderId;
    private String customerId;
    private String extraUnitsKeep;
    private String extraUnitsReturn;

    public ContainerItemEntity() {
        this.receivedDescInd = "0";
        this.ovrShrtQuantity = "0";
        this.damagedQty = "0";
        this.receivedQty = "0";
        this.receivedDeltaQty = "0";
        this.extraUnitsKeep = "0";
        this.extraUnitsReturn = "0";
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCaseQty() {
        return caseQty;
    }

    public void setCaseQty(String caseQty) {
        this.caseQty = caseQty;
    }

    public String getDamagedQty() {
        return damagedQty;
    }

    public void setDamagedQty(String damagedQty) {
        this.damagedQty = damagedQty;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getFillDcId() {
        return fillDcId;
    }

    public void setFillDcId(String fillDcId) {
        this.fillDcId = fillDcId;
    }

    public String getFillItem() {
        return fillItem;
    }

    public void setFillItem(String fillItem) {
        this.fillItem = fillItem;
    }

    public String getFillUnitPrice() {
        return fillUnitPrice;
    }

    public void setFillUnitPrice(String fillUnitPrice) {
        this.fillUnitPrice = fillUnitPrice;
    }

    public String getFillUomCode() {
        return fillUomCode;
    }

    public void setFillUomCode(String fillUomCode) {
        this.fillUomCode = fillUomCode;
    }

    public String getInvoicedQty() {
        return invoicedQty;
    }

    public void setInvoicedQty(String invoicedQty) {
        this.invoicedQty = invoicedQty;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public String getOvrShrtQuantity() {
        return ovrShrtQuantity;
    }

    public void setOvrShrtQuantity(String ovrShrtQuantity) {
        this.ovrShrtQuantity = ovrShrtQuantity;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(String receivedQty) {
        this.receivedQty = receivedQty;
    }

    public String getReceivedDeltaQty() {
        return receivedDeltaQty;
    }

    public void setReceivedDeltaQty(String receivedDeltaQty) {
        this.receivedDeltaQty = receivedDeltaQty;
    }

    public String getSeqLineNumber() {
        return seqLineNumber;
    }

    public void setSeqLineNumber(String seqLineNumber) {
        this.seqLineNumber = seqLineNumber;
    }

    public String getTenDigitNdc() {
        return tenDigitNdc;
    }

    public void setTenDigitNdc(String tenDigitNdc) {
        this.tenDigitNdc = tenDigitNdc;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getReceivedDescInd() {
        return receivedDescInd;
    }

    public void setReceivedDescInd(String receivedDescInd) {
        this.receivedDescInd = receivedDescInd;
    }

    public String getImgSmall() {
        return imgSmall;
    }

    public void setImgSmall(String imgSmall) {
        this.imgSmall = imgSmall;
    }

    public String getImgLarge() {
        return imgLarge;
    }

    public void setImgLarge(String imgLarge) {
        this.imgLarge = imgLarge;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDrgEoeOrderId() {
        return drgEoeOrderId;
    }

    public void setDrgEoeOrderId(String drgEoeOrderId) {
        this.drgEoeOrderId = drgEoeOrderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getExtraUnitsKeep() {
        return extraUnitsKeep;
    }

    public void setExtraUnitsKeep(String extraUnitsKeep) {
        this.extraUnitsKeep = extraUnitsKeep;
    }

    public String getExtraUnitsReturn() {
        return extraUnitsReturn;
    }

    public void setExtraUnitsReturn(String extraUnitsReturn) {
        this.extraUnitsReturn = extraUnitsReturn;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ContainerItemEntity.class.getSimpleName() + "[", "]")
                .add("uid='" + uid + "'")
                .add("accountId='" + accountId + "'")
                .add("caseQty='" + caseQty + "'")
                .add("damagedQty='" + damagedQty + "'")
                .add("expirationDate='" + expirationDate + "'")
                .add("fillDcId='" + fillDcId + "'")
                .add("fillItem='" + fillItem + "'")
                .add("fillDcId='" + fillDcId + "'")
                .add("fillUnitPrice='" + fillUnitPrice + "'")
                .add("fillUomCode='" + fillUomCode + "'")
                .add("invoicedQty='" + invoicedQty + "'")
                .add("itemDescription='" + itemDescription + "'")
                .add("itemNo='" + itemNo + "'")
                .add("lotNumber='" + lotNumber + "'")
                .add("ndc='" + ndc + "'")
                .add("ovrShrtQuantity='" + ovrShrtQuantity + "'")
                .add("purchaseOrderNumber='" + purchaseOrderNumber + "'")
                .add("quantity='" + quantity + "'")
                .add("receivedQty='" + receivedQty + "'")
                .add("receivedDeltaQty='" + receivedDeltaQty + "'")
                .add("seqLineNumber='" + seqLineNumber + "'")
                .add("tenDigitNdc='" + tenDigitNdc + "'")
                .add("upc='" + upc + "'")
                .add("receivedDescInd='" + receivedDescInd + "'")
                .add("imgSmall='" + imgSmall + "'")
                .add("imgLarge='" + imgLarge + "'")
                .add("invoiceNumber='" + invoiceNumber + "'")
                .add("invoiceDate=" + invoiceDate)
                .add("orderId='" + orderId + "'")
                .add("drgEoeOrderId='" + drgEoeOrderId + "'")
                .add("customerId='" + customerId + "'")
                .add("extraUnitsKeep='" + extraUnitsKeep + "'")
                .add("extraUnitsReturn='" + extraUnitsReturn + "'")
                .toString();
    }
}
