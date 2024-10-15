package Simulado.Questao02;

public class CaminhaoAlfa extends Caminhao{
    @Override
    public boolean inserePluviometro(Pluviometro p){
        double peso = 0;
        for(Pluviometro pl : pluviometro){
            peso += pl.getPeso();
        }
        if(peso + p.getPeso() <= 5000){
            pluviometro.add(p);
            return true;
        }
        return false;
    }
}
