package receiving.math;

public class ReceivingItemsMath {

    public static void main(String[] args) {


        ContainerItemEntity foundItem = new ContainerItemEntity();
        foundItem.setInvoicedQty("2");

        UpdateContainerItem request = new UpdateContainerItem();
        request.setReceivedQty("6");
        request.setDamagedQty("0"); // any
        request.setExtraUnitsKeep("0"); // !!!
        request.setExtraUnitsReturn("4");

        updateReceivedQty(foundItem, request.getReceivedQty());
        updateDamagedQty(foundItem, request.getDamagedQty());
        handleDiscrepancies(foundItem);
        updateReturnsQty(foundItem, request);

        System.out.println("InvoicedQty: "+foundItem.getInvoicedQty());
        System.out.println("ReceivedQty: "+foundItem.getReceivedQty());
        System.out.println("ReceivedDeltaQty: "+foundItem.getReceivedDeltaQty());
        System.out.println("DamagedQty: "+foundItem.getDamagedQty());
        System.out.println("ExtraUnitsKeep: "+foundItem.getExtraUnitsKeep());
        System.out.println("ExtraUnitsReturn: "+foundItem.getExtraUnitsReturn());
        System.out.println("ReceivedDescInd: "+foundItem.getReceivedDescInd());
        System.out.println("OvrShrtQuantity: "+foundItem.getOvrShrtQuantity());


    }

    private static void updateReceivedQty(ContainerItemEntity item, String rQty){
        item.setReceivedQty(calcChange(item.getReceivedQty(), rQty));
        item.setReceivedDeltaQty(calcChange(item.getReceivedDeltaQty(), rQty));
    }

    private static String calcChange(String initial, String value){
        long result = Long.parseLong(initial) + Long.parseLong(value);
        return String.valueOf(Math.max(0, result));
    }

    private static void updateDamagedQty(ContainerItemEntity item, String dQty) {
        int remaining =
                Integer.parseInt(item.getReceivedQty()) - Integer.parseInt(item.getDamagedQty());
        int i = Math.min(remaining, Integer.parseInt(dQty));
        item.setDamagedQty(calcChange(item.getDamagedQty(), String.valueOf(i)));
    }

    private static void handleDiscrepancies(ContainerItemEntity item){
        int receivedQty = Integer.parseInt(item.getReceivedQty());
        int invoicedQty = Integer.parseInt(item.getInvoicedQty());
        boolean shortage = receivedQty < invoicedQty;
        boolean overage = receivedQty > invoicedQty;
        boolean damaged = Integer.parseInt(item.getDamagedQty()) > 0;

        if (shortage || overage || damaged) {
            item.setReceivedDescInd("1");
        }else{
            item.setReceivedDescInd("0");
        }
        item.setOvrShrtQuantity(String.valueOf(Math.abs(invoicedQty - receivedQty)));
    }

    private static void updateReturnsQty(ContainerItemEntity foundItem, UpdateContainerItem request) {
        int overShortQty = Integer.parseInt(foundItem.getOvrShrtQuantity());
        int receivedQty = Integer.parseInt(foundItem.getReceivedQty());
        int invoicedQty = Integer.parseInt(foundItem.getInvoicedQty());
        int extraUnitsKeep = Integer.parseInt(request.getExtraUnitsKeep());
        int extraUnitsReturn = Integer.parseInt(request.getExtraUnitsReturn());

        if(receivedQty > invoicedQty && overShortQty > 0){
            int unitsToReturn = extraUnitsReturn > 0 ? extraUnitsReturn : overShortQty;
            foundItem.setExtraUnitsReturn(String.valueOf(unitsToReturn));
            foundItem.setExtraUnitsKeep(String.valueOf(extraUnitsKeep));

            if(Math.addExact(extraUnitsKeep, unitsToReturn) != overShortQty){
                throw new RuntimeException("Sum of units to keep and return should be equal to extra units received");
            }
        }else{
            foundItem.setExtraUnitsReturn("0");
            foundItem.setExtraUnitsKeep("0");
        }

    }
}
