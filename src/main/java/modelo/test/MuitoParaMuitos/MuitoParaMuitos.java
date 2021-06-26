package modelo.test.MuitoParaMuitos;
import modelo.Infra.DAO;
import modelo.MuitosParaMuitos.Sobrinho;
import modelo.MuitosParaMuitos.Tio;

public class MuitoParaMuitos {
    public static void main(String[] args) {
        Tio tio1 = new Tio("Maria");
        Tio tio2 = new Tio("João");

        Sobrinho sobrinho1 = new Sobrinho("Junior");
        Sobrinho sobrinho2 = new Sobrinho("Ana");

        tio1.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio1);

        tio1.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tio1);

        tio2.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio2);

        tio2.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tio2);

        DAO<Object> dao = new DAO<>();

        dao.input(tio1).input(tio2).input(sobrinho1)
                .input(sobrinho2).openTransi().closeTransi().close();
    }
}
