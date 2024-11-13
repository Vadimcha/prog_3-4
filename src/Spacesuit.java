// Класс "Скафандр Незнайки"
class Spacesuit implements Interactable {
    @Override
    public void interact(Shorty shorty) {
        System.out.printf("Spacesuit - %s обнаружил Скафандр Незнайки\n", shorty.data.name());
    }

    @Override
    public void destruct() {
        System.out.println("Spacesuit - Скафандр Незнайки был разорван в клочья");
    }
}