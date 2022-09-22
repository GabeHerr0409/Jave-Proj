/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametime;

/**
 *
 * @author Programming
 */
public class Player {
    String name;
    int atk;
    int hp;
    String type;
    
    Player(String nam, int power, int health, String warrior) {
        name = nam;
        atk = power;
        hp = health;
        type = warrior;
    }

    public int getPAtk() {
        return atk;
    }

    public int getPHp() {
        return hp;
    }
    
    public void takeDamage(int a){
        hp -= a;
    }
    
    public void heal(){
        hp += 15;
    }
    public void hpReset(int a){
        hp = a;
    }
    
    public void levelUp(){
        atk += 2;
        hp += 5;
    }
}