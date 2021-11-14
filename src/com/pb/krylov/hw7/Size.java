package com.pb.krylov.hw7;

public enum Size {
    XXS(40), XS(38), S(36), M(34), L(32),;
    private int ES;

    Size(int s) {
        this.ES=s;
    }

    public String getDescription(){
        if (ES<36) return "Детский размер";
        else return "Взрослый размер";

    }
    public int getEuroSize(){
        return ES;
    }
}