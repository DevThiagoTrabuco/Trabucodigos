package Simulado.Questao_02;

public class CaminhaoAlfa extends Caminhao{
    @Override
    public void inserePluviometro(Pluviometro p){
        double peso = 0;
        for(Pluviometro pl : pluviometro){
            peso += pl.getPeso();
        }
        if(peso + p.getPeso() <= 5000){
            pluviometro.add(p);
        }
    }
}
