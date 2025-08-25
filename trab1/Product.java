import java.util.ArrayList;
import java.util.List;

public class Product implements ISubject {
    private List<IObserver> observers = new ArrayList<>();
    private String name;
    private int amount;

    public Product(String name, int initialAmount) {
        this.name = name;
        this.amount = initialAmount;
    }

    public void setAmount(int newAmount) {
        System.out.println("\n[STOCK] Product " + name +  
        "amount in stock updated: " + newAmount);
        this.amount = newAmount;
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer: observers) {
            observer.update(this.name, this.amount);
        }
    }
}