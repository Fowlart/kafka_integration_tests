package reach_file_formats.avro;

public class CustomerTransactionTester {
    public static void main(String[] args) {
        CustomerTransactions customerTransactions = CustomerTransactions.newBuilder().build();
        System.out.println(customerTransactions);
    }
}
