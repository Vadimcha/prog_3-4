import java.util.ArrayList;

// Класс "Шкаф"
class Cabinet extends Inventory {
    @Override
    public void interact(Shorty shorty) {}

    public enum Type {FIREPROOF, GLASS, REGULAR}
    private Type type;
    private ArrayList<Interactable> content = new ArrayList<>();

    public Cabinet(Type type) {
        this.type = type;
    }
    public Cabinet(Type type, ArrayList<Interactable> content) {
        this.type = type;
        this.content = content;
    }

    @Override
    public int checkContent(Shorty shorty) {
        int amountMoney = 0;
        System.out.printf("Cabinet - %s проверяет шкаф типа \"%s\"...\n", shorty.data.name(), this.type.name());
        if(this.content.isEmpty())
            System.out.println("Cabinet - Шкаф оказался пустым");
        for(Interactable obj : this.content) {
            if (obj instanceof Money) {
                System.out.printf("Cabinet - %s нашёл деньги! В количестве %d\n", shorty.data.name(), ((Money) obj).getAmount());
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
        System.out.printf("Cabinet - Шкаф типа \"%s\" уничтожен\n", this.type.name());
        for(Interactable obj : this.content) obj.destruct();
    }
}