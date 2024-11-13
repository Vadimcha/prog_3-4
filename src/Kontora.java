import java.util.ArrayList;

// Основной класс "Контора"
class Kontora {
    private Window window;
    public Door door;
    private int fullness;
    private ArrayList<Inventory> content = new ArrayList<>();

    public Kontora() {
        this.window = new Window(new ArrayList<>() {{ new Rope("свисает вниз"); }});
        this.door = new Door(20);
        this.fullness = 0;

        final int safeAmount = (int)(Math.random() * 6) + 1;
        for(int i = 0; i < 10; ++i) {
            if(i < safeAmount) this.content.add(new Safe(Safe.Type.FIREPROOF));
            else this.content.add(new Cabinet(Cabinet.Type.FIREPROOF));
        }
        final ArrayList<Interactable> glassCabinetContent = new ArrayList<>();
        glassCabinetContent.add(new Spacesuit());
        this.content.add(new Cabinet(Cabinet.Type.GLASS, glassCabinetContent));
    }

    public void changeFullness(int amount) {
        this.fullness = amount;
        if(this.fullness == 100) System.out.println("Kontora - Контора стала полной");
    }

    public void lookAtTheWindow(Shorty shorty) {
        System.out.println("Kontora - Коротышки посмотрели в окно");
        this.window.checkContent(shorty);
    }

    public void addContent(Inventory item) {
        content.add(item);
    }

    public ArrayList<Inventory> getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Контора с уровнем заполненности: " + fullness + " и количеством объектов: " + content.size();
    }
}