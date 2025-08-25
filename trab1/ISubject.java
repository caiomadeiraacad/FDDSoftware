/*
Responsável por gerenciar os observers na lista
e notifica-los.
*/

public interface ISubject {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}