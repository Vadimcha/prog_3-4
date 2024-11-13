import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GroupOfShorties {
    private ArrayList<Shorty> shorties;
    GroupOfShorties(ArrayList<Shorty> shorties) {
        this.shorties = shorties;
    }

    public void addShorty(Shorty shorty) {
        this.shorties.add(shorty);
    }

    public void breakDoor(Door door) {
        while (door.getHP() > 0) {
            int num = (int) (Math.random() * shorties.size());
            door.interact(this.shorties.get(num));
        }
    }

    public void enterKontora(Kontora kontora) {
        System.out.println("GroupOfShorties - Коротышки быстро влетели в комнату!");
        int[] numbers = new int[shorties.size()];
        for (int i = 0; i < shorties.size(); i++)
            numbers[i] = (int)(Math.random() * shorties.size());
        for (int i = 0; i < (int)(Math.random() * shorties.size()) + 1; ++i)
            shorties.get(numbers[i]).changeNoseStatus(NoseStatus.BLOODY);

        System.out.println("GroupOfShorties - Толпа наполнила контору");
        kontora.changeFullness(100);
    }

    public void searchMoney(Kontora kontora) {
        System.out.println("Часть коротышек побежала проверять шкафы, другая часть к сундуки");
        List<ArrayList<Shorty>> list = Arrays.asList(this.shorties);
        Collections.shuffle(list);
        int i = 0, sumMoney = 0;
        for(Inventory obj : kontora.getContent()) {
            sumMoney += obj.checkContent(this.shorties.get(i));
            i = (i + 1) % this.shorties.size();
        }
        if(sumMoney == 0) {
            System.out.println("GroupOfShorties - Убедившись что денег нигде нет:");
            for(Shorty shorty : this.shorties)
                shorty.changeFerocity(100);
            kontora.getContent().get(kontora.getContent().size() - 1).destruct();
        }
        kontora.lookAtTheWindow(this.shorties.get(0));
    }
}