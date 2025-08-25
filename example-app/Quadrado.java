public class Quadrado {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double calculaArea() {
        return lado * lado;
    }    
    
    public double calculaPerimetro() {
        return 4 * lado;
    }    
    
    public void desenha() {
        // Desenha um circulo
        System.out.println("Quadrado de lado: " + lado);
    }

    
}
