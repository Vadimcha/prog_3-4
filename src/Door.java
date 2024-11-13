// Класс "Дверь"
class Door implements Interactable {
    private int HP;

    public Door(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return this.HP;
    }

    public void changeHp(int damage) {
        this.HP += damage;
        crackle(-1 * damage);
        if (this.HP <= 0)
            this.flyOffTheHinges();
    }

    public void flyToTheFloor() {
        System.out.println("Door - Дверь упала на пол!");
    }

    public void flyOffTheHinges() {
        System.out.println("Door - Дверь слетела с петель!");
        flyToTheFloor();
    }

    public void crackle(int damage) {
        System.out.printf("Door - Дверь трещит и теряет %d HP! (осталось %d HP)\n", damage, Math.max(this.getHP(), 0));
    }

    @Override
    public void interact(Shorty shorty) {
        shorty.useRam(this);
    }

    @Override
    public void destruct() {}
}