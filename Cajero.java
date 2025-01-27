public class Cajero extends Thread{

    private int id;

    private int[][] filaClientes;

    private double factorDeCansancio;

    public Cajero(int id){
        this.id = id;
    }

    public void run(){

        for(int i = 1; i < 11; i++){
            System.out.println("Cajero con id "+ id + " contando en " + i);
        }

    }


    public double tiempoCalculado(int tiempoBase, double factorDeCansancio){
        return tiempoBase * factorDeCansancio;
    }
    


}