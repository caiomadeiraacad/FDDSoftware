/*
Essa interface deve ser implementada pelo assinantes (Observers).
A principio, eles é que são os interessados no estoque.

*/

public interface IObserver {
    void update(String productName, int amount);
}