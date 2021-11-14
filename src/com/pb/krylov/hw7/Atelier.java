package com.pb.krylov.hw7;

public class Atelier {
    public static void main(String[] args) {
 Pants pants =new Pants (Size.S,100,"black");
 Tshirt tshirt =new Tshirt (Size.L,10,"red");
 Skirt skirt =new Skirt (Size.M,70,"white");
 Tie tie=new Tie(Size.L,50,"zebra");
  Clothes [] aclothes = new Clothes[]{pants,tie,tshirt,skirt};
dressMan(aclothes);
        dressWomen(aclothes);
    }
    public static void dressMan(Clothes[] clothes){
        System.out.println("Мужская одежда!!!");
        for (Clothes clothes1: clothes) {
            if (clothes1 instanceof ManClothes) {
                ManClothes mc = (ManClothes) clothes1;
                mc.dressMan();
                System.out.println("Размер: " +clothes1.getSize()+" Евро :"+ clothes1.getSize().getEuroSize()+ " Описание :" +clothes1.getSize().getDescription()+" Цвет: "+ clothes1.getColor()+" Цена: "+clothes1.getCost());

            }
        }
    }
    public static void dressWomen(Clothes[] clothes){
        System.out.println("Женская одежда!!!");
        for (Clothes clothes1: clothes) {
            if (clothes1 instanceof WomenClothes) {
                WomenClothes mc = (WomenClothes) clothes1;
                mc.dressWomen();
                System.out.println("Размер: " +clothes1.getSize()+" Евро :"+ clothes1.getSize().getEuroSize()+ " Описание :" +clothes1.getSize().getDescription()+" Цвет: "+ clothes1.getColor()+" Цена: "+clothes1.getCost());

            }
        }

    }
}
