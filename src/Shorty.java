import java.util.Random;

// Запись для хранения данных коротышек
record ShortyData(String name, int energyLevel) {}

record RamData(String name, int power) {}

// Класс "Коротышки"
class Shorty {
    public ShortyData data;
    private RamData ram;
    private NoseStatus noseStatus;
    private int ferocity;
    private Random random = new Random();

    public Shorty(String name, int energyLevel, String ramName) {
        this.data = new ShortyData(name, energyLevel);
        this.ram = new RamData(ramName, (int) (Math.random() * 20 + 1));
        this.noseStatus = NoseStatus.NORMAL;
        this.ferocity = 50;
    }

    public void useRam(Door door) {
        System.out.printf("Shorty - %s использует таран \"%s\" c силой %d\n", data.name(), this.ram.name(), this.ram.power());
        door.changeHp(-1 * this.ram.power());
    }

    public void interactWithObject(Interactable object) {
        object.interact(this);
    }

    public void changeNoseStatus(NoseStatus newStatus) {
        this.noseStatus = newStatus;
        System.out.printf("Shorty - %s расквасил себе нос :(\n", data.name());
    }

    public void changeFerocity(int level) {
        this.ferocity = level;
        if(ferocity == 100)
            System.out.printf("Shorty - %s сильно рассвирепел (ferocity lvl: 100)\n", this.data.name());
    }

    public void randomAction(Kontora kontora) {
        int choice = random.nextInt(kontora.getContent().size());
        interactWithObject(kontora.getContent().get(choice));
    }

    @Override
    public String toString() {
        return "Shorty - Коротышка " + data.name() + " с уровнем энергии: " + data.energyLevel() + " и статусом носа: " + noseStatus;
    }
}