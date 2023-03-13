package org.example;

public class Computer {
    String HDD;
    String RAM;

    boolean isGraphicsCardEnabled;
    boolean isBluetoothEnabled;

    private Computer(){}
    static class Builder{
        String HDD;
        String RAM;

        public Builder(String RAM,String HDD) {
            this.HDD=HDD;
            this.RAM = RAM;
        }

        public Builder(String HDD,String RAM,boolean isGraphicsCardEnabled,boolean isBluetoothEnabled) {
            this.HDD=HDD;
            this.RAM = RAM;
            this.isBluetoothEnabled=isBluetoothEnabled;
            this.isGraphicsCardEnabled=isGraphicsCardEnabled;
        }

        boolean isGraphicsCardEnabled;
        boolean isBluetoothEnabled;
        Computer build(){
            Computer a=new Computer();
            a.HDD=this.HDD;
            a.RAM=this.RAM;
            a.isBluetoothEnabled=this.isBluetoothEnabled;
            a.isGraphicsCardEnabled=this.isGraphicsCardEnabled;
            return a;
        }
    }
}
