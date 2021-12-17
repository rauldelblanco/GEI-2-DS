package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.Month;

class GestionDeBilletesTest {
    GestionDeBilletes BilletesTotales= new GestionDeBilletes();

    Origen Sansenxo = new Origen("Sansenxo");
    Origen Bierzo = new Origen("Bierzo");
    Origen Cambados = new Origen("Cambados");
    Origen Villagarcia = new Origen("Santiago");
    Origen Coruna = new Origen("Coruña");

    Destino Paris = new Destino("Paris");
    Destino Berlin = new Destino("Berlín");
    Destino Andorra = new Destino("Andorra");
    Destino Barcelona = new Destino("Barcelona");
    Destino Moscow = new Destino("Moscow");


    Precio Bussines = new Precio(100);
    Precio Turista = new Precio(25);
    Precio Preferente = new Precio(60);
    Precio Economico = new Precio(20);
    Precio VIP= new Precio(150);
    Precio Ninos= new Precio(5);

    Fecha Navidad = new Fecha(LocalDateTime.of(2021,Month.DECEMBER,25,10,10));
    Fecha FinDeAno = new Fecha(LocalDateTime.of(2021,Month.DECEMBER,31,10,30));
    Fecha Reyes = new Fecha(LocalDateTime.of(2022,Month.DECEMBER,6,13,5));
    Fecha Random1 = new Fecha(LocalDateTime.of(2021,Month.AUGUST,8,19,45));
    Fecha Random2 = new Fecha(LocalDateTime.of(2021,Month.APRIL,27,23,40));


    Billetes billete1 = new Billetes(Sansenxo,Paris,Bussines,Navidad);
    Billetes billete2 = new Billetes(Bierzo,Berlin,Turista,FinDeAno);
    Billetes billete3 = new Billetes(Cambados,Andorra,Preferente,Reyes);
    Billetes billete4 = new Billetes(Villagarcia,Barcelona,VIP,Random2);
    Billetes billete5 = new Billetes(Coruna,Moscow,Ninos,Random2);
    Billetes billete6 = new Billetes(Cambados,Berlin,Turista,Random2);
    Billetes billetes7 = new Billetes(Coruna,Berlin,Economico,Random1);
    Billetes billetes8 = new Billetes(Coruna,Berlin,VIP,Random2);
    Billetes billetes9 = new Billetes(Coruna,Berlin,Economico,Random2);

    @Test
    void AnadiryLimpiarBilletes(){
        Billetes billete1 = new Billetes(Sansenxo,Paris,Turista,Navidad);
        Billetes billete2 = new Billetes(Bierzo,Berlin,Economico,FinDeAno);
        Billetes billete3 = new Billetes(Sansenxo,Moscow,Preferente,Random1);

        BilletesTotales.AnadirBilletes(billete1);
        BilletesTotales.AnadirBilletes(billete2);
        BilletesTotales.AnadirBilletes(billete3);

        assertEquals("""
                Billete: Sansenxo Paris 25.0 2021-12-25T10:10
                Billete: Bierzo Berlín 20.0 2021-12-31T10:30
                Billete: Sansenxo Moscow 60.0 2021-08-08T19:45""",BilletesTotales.ImprimirLista());

        BilletesTotales.resetLista();
        assertEquals("",BilletesTotales.ImprimirLista());
    }

    @Test
    void FiltrarListaOr(){
        Or or = new Or();
        BilletesTotales.AnadirBilletes(billete1);
        BilletesTotales.AnadirBilletes(billete2);
        BilletesTotales.AnadirBilletes(billete3);
        BilletesTotales.AnadirBilletes(billete4);
        BilletesTotales.AnadirBilletes(billete5);
        BilletesTotales.AnadirBilletes(billete6);
        BilletesTotales.AnadirBilletes(billetes7);

        BilletesTotales.FiltrarBilletes(or,Coruna,Cambados);//billetes con origen en cambados o coruña
        assertEquals("""
                Billete: Coruña Moscow 5.0 2021-04-27T23:40
                Billete: Coruña Berlín 20.0 2021-08-08T19:45
                Billete: Cambados Andorra 60.0 2022-12-06T13:05
                Billete: Cambados Berlín 25.0 2021-04-27T23:40""", BilletesTotales.ImprimirLista());

        BilletesTotales.FiltrarBilletes(or,Berlin,Andorra);//De la clausula anterior sumamos que los destinos sean o berlin o andorra
        assertEquals("""
                Billete: Coruña Berlín 20.0 2021-08-08T19:45
                Billete: Cambados Berlín 25.0 2021-04-27T23:40
                Billete: Cambados Andorra 60.0 2022-12-06T13:05""",BilletesTotales.ImprimirLista());

        BilletesTotales.FiltrarBilletes(or,Turista);//De la clausula anterior sumamos que el precio sea menor o igual que turiste
        assertEquals("Billete: Coruña Berlín 20.0 2021-08-08T19:45\n" +
                "Billete: Cambados Berlín 25.0 2021-04-27T23:40",BilletesTotales.ImprimirLista());

        BilletesTotales.FiltrarBilletes(or,Random1);//De la claudula anterior sumamos que la fecha sea la indicada lo que solo nos da un resultado
        assertEquals("Billete: Coruña Berlín 20.0 2021-08-08T19:45",BilletesTotales.ImprimirLista());


        BilletesTotales.FiltrarBilletes(or,Sansenxo,Bierzo);//Como no esxiste nos devuelve una lista vacia
        assertEquals("",BilletesTotales.ImprimirLista());
    }

    @Test
    void FiltrarListaAnd(){
        And and = new And();
        BilletesTotales.AnadirBilletes(billete1);
        BilletesTotales.AnadirBilletes(billete2);
        BilletesTotales.AnadirBilletes(billete3);
        BilletesTotales.AnadirBilletes(billete4);
        BilletesTotales.AnadirBilletes(billete5);
        BilletesTotales.AnadirBilletes(billete6);
        BilletesTotales.AnadirBilletes(billetes7);
        BilletesTotales.AnadirBilletes(billetes8);
        BilletesTotales.AnadirBilletes(billetes9);

        BilletesTotales.FiltrarBilletes(and,Coruna,Berlin);//billetes con origen Coruña y destino Berlín
        assertEquals("""
                Billete: Coruña Berlín 20.0 2021-08-08T19:45
                Billete: Coruña Berlín 150.0 2021-04-27T23:40
                Billete: Coruña Berlín 20.0 2021-04-27T23:40""", BilletesTotales.ImprimirLista());
        BilletesTotales.FiltrarBilletes(and,Economico,Random2);
        assertEquals("Billete: Coruña Berlín 20.0 2021-04-27T23:40",BilletesTotales.ImprimirLista());
    }
}