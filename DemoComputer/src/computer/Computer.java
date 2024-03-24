package computer;

public class Computer {
    private String name;
    private boolean turnedOn;
    private CPU cpu;
    private DiskDrive diskDrive;
    private HardDrive hardDrive;
    private RAM ram;

    public Computer(String name, CPU cpu, DiskDrive diskDrive, HardDrive hardDrive, RAM ram) {
        this.name = name;
        this.turnedOn = false;
        this.cpu = cpu;
        this.diskDrive = diskDrive;
        this.hardDrive = hardDrive;
        this.ram = ram;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void turnOn(){
        this.turnedOn = true;
    }
    
    public void turnOff(){
        this.turnedOn = false;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public DiskDrive getDiskDrive() {
        return diskDrive;
    }

    public void setDiskDrive(DiskDrive diskDrive) {
        this.diskDrive = diskDrive;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }
    
    public void checkHardDriveForViruses(){
        if(this.getHardDrive().virusCheck()){
            System.out.println("При проверке жесткого диска было обнаруженно вредоносное программное обеспечение.");
        } else{
           System.out.println("При проверке жесткого диска вредоносного программного обеспечения обнаруженно не было."); 
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.name.equals(((Computer)other).getName());
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
