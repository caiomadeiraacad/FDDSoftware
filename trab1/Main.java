public class Main {
    public static void main(String args[]) {

        Product iphone16pro = new Product("Iphone 16 Pro", 0);
        
        IObserver customer1 = new CustomerNotifier("João");
        IObserver customer2 = new CustomerNotifier("Marcos");
        IObserver customer3 = new CustomerNotifier("Daniela");
        IObserver stockManager = new StockManagerNotifier();

        // lista d espera dos clientes p/ receber o produto
        iphone16pro.registerObserver(customer1); 
        iphone16pro.registerObserver(customer2); 
        iphone16pro.registerObserver(customer3); 
        iphone16pro.registerObserver(stockManager);
        
        iphone16pro.setAmount(10);

        System.out.println("Customer 1 [João] purchased the product.\n Removing from observers...\n");
        iphone16pro.removeObserver(customer1);
        iphone16pro.setAmount(4);

    }
}