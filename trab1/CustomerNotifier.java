public class CustomerNotifier implements IObserver {
    private String name;
    
    public CustomerNotifier(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName, int amount) {
        if (amount > 0) {
            System.out.println("To Customer [" + name + "]: The product " + productName +  " is back in stock!\n");
        }
    }
}