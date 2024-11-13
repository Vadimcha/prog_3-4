// Абстрактный класс "Инвентарь"
abstract class Inventory implements Interactable {
    protected ObjectStatus status;

    public Inventory() {
        this.status = ObjectStatus.INTACT;
    }

    // Абстрактный метод для проверки содержимого
    public abstract int checkContent(Shorty shorty);

    public ObjectStatus getStatus() {
        return status;
    }
}