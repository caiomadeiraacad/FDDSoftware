public class Circulo {
    
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double calculaArea() {
        return Math.PI * raio * raio;
    }    

    public double calculaPerimetro() {
        return 2 * Math.PI * raio;
    }
    
    public void desenha() {
        // Desenha um circulo
        System.out.println("Circulo de raio: "+raio);
    }
    
}
