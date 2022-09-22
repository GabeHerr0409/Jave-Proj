package gametime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Programming
 */
public class Enemy {
    String name;
    int atk;
    int hp;
    
    public Enemy(String nam, int power, int heal){
        name = nam;
        atk = power;
        hp = heal;
    }
    public int getEAtk() {
        return atk;
    }

    public int getEHp() {
        return hp;
    }
    
    public void dealDamage(int b){
        hp = hp - b;
    }
    
}
