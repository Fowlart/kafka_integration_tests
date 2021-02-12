package receiving.math;


public class UpdateContainerItem {

    private String customerId;

    private String containerId;

    private String uid;

    private String receivedQty = "0";

    private String damagedQty = "0";

    private String extraUnitsKeep = "0";

    private String extraUnitsReturn = "0";

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(String receivedQty) {
        this.receivedQty = receivedQty;
    }

    public String getDamagedQty() {
        return damagedQty;
    }

    public void setDamagedQty(String damagedQty) {
        this.damagedQty = damagedQty;
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
}
