package Simulado.Questao02;

public class CaminhaoBeta extends Caminhao{
    @Override
    public boolean inserePluviometro(Pluviometro p){
        boolean exists = false;
        for(Pluviometro pl : pluviometro){
            if(pl.getTipo().equals(p.getTipo())){
                exists = true;
                break;
            }
        }
        if(!exists){
            pluviometro.add(p);
            return true;
        }
        return false;
    }
}
