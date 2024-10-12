package Simulado.Questao_02;

public class CaminhaoBeta extends Caminhao{
    @Override
    public void inserePluviometro(Pluviometro p){
        boolean exists = false;
        for(Pluviometro pl : pluviometro){
            if(pl.getTipo().equals(p.getTipo())){
                exists = true;
                break;
            }
        }
        if(!exists){
            pluviometro.add(p);
        }
    }
}
