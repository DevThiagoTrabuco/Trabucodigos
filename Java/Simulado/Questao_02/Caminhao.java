package Simulado.Questao_02;

import java.util.ArrayList;
import java.util.List;

public abstract class Caminhao{
     protected List<Pluviometro> pluviometro = new ArrayList<>();

    public abstract void inserePluviometro(Pluviometro p);
}
