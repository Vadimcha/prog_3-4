// Класс "Веревка"
class Rope implements Interactable {
    private String status;

    public Rope(String status) {
        this.status = status;
    }

    @Override
    public void interact(Shorty shorty) {
        System.out.printf("Rope - Веревка. Статус: %s\n", this.status);
    }

    @Override
    public void destruct() {}
}