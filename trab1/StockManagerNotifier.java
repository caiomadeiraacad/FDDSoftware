public class StockManagerNotifier implements IObserver {
    private static final int STOCK_LIMIT = 5;

    @Override
    public void update(String productName, int amount) {
        if (amount <= STOCK_LIMIT) {
            System.out.println("[ALERT] the stock of " 
            + productName + " x is running out. Left in:" 
            + amount + "\n");
        }
    }
}