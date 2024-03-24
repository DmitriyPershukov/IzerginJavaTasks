package democomputer;

import computer.CPU;
import computer.Computer;
import computer.DiskDrive;
import computer.HardDrive;
import computer.RAM;

public class DemoComputer {

    public static void main(String[] args) {
        CPU cpu = new CPU("Intel Core i3 1115G4", 2, 3);
        DiskDrive diskDrive = new DiskDrive("Disk Drive mk2");
        HardDrive hardDrive = new HardDrive("LENOVO 900Gb 10K 2,5inch harddrive v2", 1000);
        RAM ram = new RAM("DDR4", 16);
        Computer pc = new Computer("Infinix Inbook Y2 PLUS XL29 i3/16GB/512GB Grey", cpu, diskDrive, hardDrive, ram);
        pc.turnOn();
        pc.checkHardDriveForViruses();
        pc.getHardDrive().printSize();
        pc.turnOff();
    }
    
}
