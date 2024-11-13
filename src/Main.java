import java.util.ArrayList;


// Основной класс программы
public class Main {
    public static void main(String[] args) {
        Kontora kontora = new Kontora();

        String[] names = {"Забияка", "Шустрик", "Малыш", "Храбрец", "Весельчак", "Болтун", "Незнайка", "Умник", "Ловкач"};

        // Случайное количество коротышек от 3 до 5
        int numShorties = (int)(Math.random() * (7 - 4 + 1)) + 4; // от 4 до 7
        GroupOfShorties group = new GroupOfShorties(new ArrayList<>());

        for (int i = 0; i < numShorties; i++) {
            String name = names[(int)(Math.random() * names.length)];
            int energyLevel = (int)(Math.random() * 51) + 50;
            group.addShorty(new Shorty(name, energyLevel, "крышка от письменного стола"));
        }

        group.breakDoor(kontora.door);
        group.enterKontora(kontora);
        group.searchMoney(kontora);
    }
}
