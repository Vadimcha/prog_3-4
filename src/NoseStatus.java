// Перечисление для эмоций коротышек
enum NoseStatus {
    NORMAL("Нормальный"), BLOODY("Расквашенный");
    private String ruStatus;
    NoseStatus(String ruStatus){
        this.ruStatus = ruStatus;
    }
    public String getRuStatus(){ return ruStatus; }
}