package com.pb.krylov.hw13;

import java.util.LinkedList;

public class Buffer {
    private LinkedList buf =new LinkedList();
    private final int maxSize;

    public boolean append(Object str){
        if (buf.size()<maxSize) {buf.add(str);return true;}
        else return false;

    }
    public boolean isFull(){
        if (buf.size()==maxSize) return true;
        else return false;
    }
    public Object read(){
        return buf.removeFirst();
    }
    public boolean isEmpty(){
       return buf.isEmpty();
    }
    public Buffer(int maxSize) {
        this.maxSize = maxSize;
    }




    public int getBufSize() {
        return buf.size();
    }
}
