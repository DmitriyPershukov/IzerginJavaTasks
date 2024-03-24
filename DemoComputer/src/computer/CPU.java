package computer;

public class CPU {
    private String name;
    private int coreNumber;
    private float clockSpeedGHz;
    
    public CPU(String name, int coreNumber, int clockSpeedGHz){
        this.name = name;
        this.coreNumber = coreNumber;
        this.clockSpeedGHz = clockSpeedGHz;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getCoreNumber(){
        return this.coreNumber;
    }
    
    public float getClockSpeedGHz(){
        return this.clockSpeedGHz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoreNumber(int coreNumber) {
        this.coreNumber = coreNumber;
    }

    public void setClockSpeedGHz(int clockSpeedGHz) {
        this.clockSpeedGHz = clockSpeedGHz;
    }
    
    
    
    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.name.equals(((CPU)other).getName());
        } else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
