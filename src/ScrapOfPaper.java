import java.util.ArrayList;

public class ScrapOfPaper implements Interactable {

    @Override
    public void interact(Shorty shorty) {
        System.out.println("ScrapOfPaper - Был обнаружен обрывок бумаги со следами пачек акций :(");
    }

    @Override
    public void destruct() {}
}
