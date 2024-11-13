public class Money implements Interactable {
    public int amount = 0;
    public Money() {}
    public Money(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return this.amount;
    }
    @Override
    public void interact(Shorty shorty) {}

    @Override
    public void destruct() {}
}
