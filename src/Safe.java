import java.util.ArrayList;

// Класс "Сундук"
class Safe extends Inventory {
    @Override
    public void interact(Shorty shorty) {}

    public enum Type {FIREPROOF, GLASS, REGULAR}
    private Type type;
    private ArrayList<Interactable> content;

    public Safe(Type type) {
        this.type = type;
        this.content = new ArrayList<Interactable>();
        for(int i = 0; i < (int) (Math.random() * 3); ++i) {
            addItem(new ScrapOfPaper());
        }
    }

    public void addItem(Interactable item) {
        content.add(item);
    }

    @Override
    public int checkContent(Shorty shorty) {
        System.out.printf("Safe - %s проверяет сундук типа \"%s\"...\n", shorty.data.name(), this.type.name());
        if(this.content.isEmpty())
            System.out.println("Safe - Сундук оказался пустым");
        int amountMoney = 0;
        for(Interactable obj : this.content) {
            if (obj instanceof Money) {
                System.out.printf("Safe - %s нашёл деньги! В количестве %d\n", shorty.data.name(), ((Money) obj).getAmount());
                amountMoney += ((Money) obj).getAmount();
            }
            else {
                obj.interact(shorty);
            }
        }
        return amountMoney;
    }

    @Override
    public void destruct() {
        this.status = ObjectStatus.DESTROYED;
        System.out.println("Safe - Сундук уничтожен.");
    }
}