public class Cajero extends Thread{

    private int id;

    private int[] filaClientes;

    private double factorDeCansancio;

    public Cajero(int id, int[] filaClientes){
        this.id = id;
        this.filaClientes = filaClientes;
        this.factorDeCansancio = 1.0;
    }

    public void run(){

        for(int i = 1; i < filaClientes.length+1; i++){
            System.out.println("El cajero "+ id + " comienza a procesar la fila " + i);
            recepcionCliente(i, filaClientes[i-1]);
            try {
                Thread.sleep((int) tiempoCalculado(filaClientes[i-1], factorDeCansancio));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cansancioAcumulado(filaClientes[i-1]);
        }
        System.out.println("El cajero "+ id + " ha terminado de atender");

    }


    public double tiempoCalculado(int tiempoBase, double factorDeCansancio){
        return tiempoBase * factorDeCansancio;
    }

    public void recepcionCliente(int cliente, int tiempo){
        int tiempoCalculado = (int) tiempoCalculado(tiempo, factorDeCansancio);
        System.out.println("El cajero " + id + " atendiendo al cliente " + cliente + " de la fila " + id + " (tiempo de procesammiento básico: " + tiempo + "ms) factor de cansancio actual: " + factorDeCansancio + " tiempo de procesamiento actual: " + tiempoCalculado + "ms");
    }

    public void cansancioAcumulado(int tiempoBase){
        this.factorDeCansancio = this.factorDeCansancio + (tiempoBase * 0.001);
    }
    


}