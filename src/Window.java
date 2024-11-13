import java.util.ArrayList;
import java.util.List;

// Класс "Окно"
class Window extends Inventory {
    private ArrayList<Interactable> content;

    public Window(ArrayList<Interactable> content) {
        this.content = content;
    }

    @Override
    public int checkContent(Shorty shorty) {
        System.out.println("Window - В окне можно было увидеть");
        for(Interactable obj : content) obj.interact(shorty);
        return 0;
    }

    @Override
    public void interact(Shorty shorty) {
        System.out.println("Window - Коротышка смотрит в окно.");
    }

    @Override
    public void destruct() {}
}