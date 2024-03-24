package bird;

public class Broody<T extends Bird>{
    private T bird;
    
    public Broody(T bird){
        this.bird = bird;
    }

    public T getBird() {
        return bird;
    }

    public void setBird(T bird) {
        this.bird = bird;
    }
    
    public void layEggs(){
        System.out.println(getBird().getName() + " lays eggs.");
    }
    
    public void incubateEggs(){
        System.out.println(getBird().getName() + " incubates eggs.");
    }
}
