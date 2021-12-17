package e1;

import java.util.ArrayList;
import java.util.List;

public class GestionDeBilletes {
    private List<Billetes> BilletesTotales = new ArrayList<>();

    public void AnadirBilletes(Billetes billete){
        BilletesTotales.add(billete);
    }

    public void resetLista(){
        BilletesTotales.clear();
    }

    public void FiltrarBilletes(ORyAND OryAnd, Comparaciones... propiedades){
        this.BilletesTotales = OryAnd.ORYAND(BilletesTotales, propiedades);
    }

    public String ImprimirLista (){
        StringBuilder fin = new StringBuilder();
        for (Billetes billete : BilletesTotales) {
            fin.append(billete.toString()).append("\n");
        }
        return fin.toString().trim();
    }
}
