/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|
|   Project: WBL: Game Time!
|   Name: Gabriel Herrera
|   Date: 2/8/2022
|   Description: A text based dungeon game where you select a class and select an opponet.
|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*/
package gametime;
import java.util.Scanner;
/**
 *
 * @author Programming
 */
public class GameTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Basic stats for the player
        int health;
        int power;
        int speed;
        int checkCount = 0;
        String move;
        String clas;
        
        //Setting the scene and gathering info
        System.out.println("Welcome to Dungeon Battles...");
        System.out.println("What is your name?");
        String nam = input.next();
        System.out.println(nam + "... hehe");
        System.out.println("Developers notes - Be aware of your spelling and capilization!");
        System.out.println("You have the choice of four classes...");
        System.out.println("Warrior, Rouge, Mage, and Healer");
        System.out.println("Would you like more info on the classes?");
        System.out.println("Yes          No");
        //Determins weather or not the playe want more info, will prinf info on classes if "Yes"
        if("Yes".equals(input.next())){
            System.out.println("Warrior: An armor clad fighter, equiped with a broad iron sword and steel armor.");
            System.out.println("Attack: 15");
            System.out.println("Health Points: 120");
            System.out.println("Rouge: A thief with quick attacks. Covered in light garbs for mobility, they carry daggers for quick attacks.");
            System.out.println("Attack: 17");
            System.out.println("Health Points: 80");
            System.out.println("Mage: A spell caster with high magical abilities. They carry a wooden staff and wear Mage Robes.");
            System.out.println("Attack: 16");
            System.out.println("Health Points: 100");
            System.out.println("Healer: A diffrent type of spell caster, diffrent from the Mages. With more defensive powers and less offensive powers. Also equiped with a wooden staff and Mage Robes");
            System.out.println("Attack: 13");
            System.out.println("Health Points: 140");
        }
        System.out.println("Select Class: ");
        
        //Selects class and decides the stats via that way
        clas = input.next();
        Player player;
        if("Warrior".equals(clas)){
            power = 15;
            health = 120;
            player = new Player(nam, power, health, "Warrior");
        } else {
            if("Rouge".equals(clas)){
                power = 17;
                health = 80;
                player = new Player(nam, power, health, "Rouge");
            } else {
                if("Mage".equals(clas)){
                power = 16;
                health = 110;
                player = new Player(nam, power, health, "Mage");
            } else {
                    power = 13;
                    health = 140;
                    player = new Player(nam, power, health, "Healer");
                }
            }
        }
        
        //Asks the user what door/enemy they would like to fight.
        System.out.println("Hehe... welcome, " + nam + " the " + clas + "...");
        System.out.println("Now for the rules...");
        System.out.println("This is turn based fighting, you'll typically take the first turn.");
        System.out.println("Once your HP reaches 0... you lose. Though this rule applies to your enemy.");
        System.out.println("You do damage based on your attack power.");
        System.out.println("You have four actions you can preform in your turn.");
        System.out.println("Attack: A genaric attack, doing damage based off your attack stat.");
        System.out.println("Magic: Sacrifice 10HP to preform an attack that does damage that is twice your attack stat. Unless you are a Healer, Healer's use thier turn to heal 15 HP.");
        System.out.println("Defend: Blocks the damage from your opponet's next attack.");
        System.out.println("Check: Use your turn to check your opponet's stats. Doing so also gives you view of thier HP through the battle.");
        System.out.println("Now... you have three doors in front of you... Door A, B, and C.");
        System.out.println("Each door contains a monster, you must fight and win to prove yourself. Each door contains a monster, some stronger than others.");
        System.out.println("So... select your door... hehe... A, B, or C?");
        String door = input.next();
        
        //The game will now go down seperate paths in which the enemies you fight will be different
        if("A".equals(door) || "a".equals(door)){
            Enemy goblin = new Enemy("Goblin", 15, 80);
            
            System.out.println("You walk through door A to find a tiny goblin... with a dagger in his hand!");
            System.out.println("Your battle with Goblin started!");
            while(player.getPHp() > 0 && goblin.getEHp() > 0){
                
                System.out.println("Player HP: " + player.getPHp());
                if(checkCount > 0){
                    System.out.println("Enemy HP: " + goblin.getEHp());
                }
                
                //The Player's turn is played out with an input and decided based on if else statements.
                
                System.out.println("Select your move: ");
                move = input.next();
                if(move.equals("Attack")){
                    System.out.println("You attacked! You dealt " + power + " point of damage.");
                    goblin.dealDamage(power);
                } else {
                    if(move.equals("Magic")){
                        if(clas.equals("Warrior")){
                            System.out.println("You charged your sword with a flame of rage and attacked! You dealt 30 points of damage.");
                            goblin.dealDamage(power * 2);
                            player.takeDamage(10);
                        } else {
                            if(clas.equals("Rouge")){
                                System.out.println("You performed a multi stab attack! You dealt 34 points of damage.");
                                goblin.dealDamage(power * 2);
                                player.takeDamage(10);
                            } else {
                                if(clas.equals("Mage")){
                                    System.out.println("You perform a magic fireball attack! You dealt 32 points of damage but took 10 points of Damage.");
                                    goblin.dealDamage(power * 2);
                                    player.takeDamage(10);
                                } else {
                                    System.out.println("You casted a healing spell on yourself. You regained 15HP.");
                                    player.heal();
                                }
                            }
                        }
                    } else {
                        if(move.equals("Defend")){
                            System.out.println("You entered a defensive pose");
                        } else {
                            if(move.equals("Check")){
                                System.out.println("You gather the stats of your opponet. Max HP is 80 and Attack power is 15");
                                checkCount++;
                            }
                        }
                    }
                }
                
                //The opposing monster has what I like to call "Simple AI", they will only do a basic attack though I plan on changing that in the future.
                System.out.println("The goblin snarled at you before lunging at you with a slash attack.");
                if(move.equals("Defend")){
                    System.out.println("Your defensive stance blocked the attack!");
                } else {
                    player.takeDamage(20);
                    System.out.println("You took 15 points of damage!");
                }
            }
            
            //If else statement to determine how o end the game based off of player HP
            if(player.getPHp() <= 0){
                System.out.println("YOU DIED");
                System.out.println("Game Over!");
            } else {
                player.hpReset(health);
                System.out.println("The Goblin fell backwards into his back before exploding into dust!");
                System.out.println("You win!");
                System.out.println("Gained 20 EXP");
                System.out.println("Congrats! You leveled up!");
                System.out.println("Attack increased by 2!");
                System.out.println("Max Health increased by 5!");
                player.levelUp();
                System.out.println("Congrats! You finished the tutorial!");
            }
            
        }
        
        if("B".equals(door) || "b".equals(door)){
            Enemy mimic = new Enemy("Mimic", 10, 200);
            
            System.out.println("You enter door B to find a treasure chest... with teeth!");
            System.out.println("Your battle with Mimic started!");
            
            while(player.getPHp() > 0 && mimic.getEHp() > 0){
                
                System.out.println("Player HP: " + player.getPHp());
                if(checkCount > 0){
                    System.out.println("Enemy HP: " + mimic.getEHp());
                }
                
                //The Player's turn is played out with an input and decided based on if else statements.
                
                System.out.println("Select your move: ");
                move = input.next();
                if(move.equals("Attack")){
                    System.out.println("You attacked! You dealt " + power + " point of damage.");
                    mimic.dealDamage(power);
                } else {
                    if(move.equals("Magic")){
                        if(clas.equals("Warrior")){
                            System.out.println("You charged your sword with a flame of rage and attacked! You dealt 30 points of damage.");
                            mimic.dealDamage(power * 2);
                        } else {
                            if(clas.equals("Rouge")){
                                System.out.println("You performed a multi stab attack! You dealt 34 points of damage.");
                                mimic.dealDamage(power * 2);
                            } else {
                                if(clas.equals("Mage")){
                                    System.out.println("You perform a magic fireball attack! You dealt 32 points of damage.");
                                    mimic.dealDamage(power * 2);
                                } else {
                                    System.out.println("You casted a healing spell on yourself. You regained 15HP.");
                                    player.heal();
                                }
                            }
                        }
                    } else {
                        if(move.equals("Defend")){
                            System.out.println("You entered a defensive pose");
                        } else {
                            if(move.equals("Check")){
                                System.out.println("You gather the stats of your opponet. Max HP is 200 and Attack power is 10");
                            }
                        }
                    }
                }
                
                //The opposing monster has what I like to call "Simple AI", they will only do a basic attack though I plan on changing that in the future.
                System.out.println("The mimick tried to bite you!");
                if(move.equals("Defend")){
                    System.out.println("Your defensive stance blocked the attack!");
                } else {
                    player.takeDamage(10);
                    System.out.println("You took 10 points of damage!");
                }
            }
            
            //If else statement to determine how o end the game based off of player HP
            if(player.getPHp() <= 0){
                System.out.println("YOU DIED");
                System.out.println("Game Over!");
            } else {
                player.hpReset(health);
                System.out.println("The Mimic's jaw hung open before it exploded into dust!");
                System.out.println("You win!");
                System.out.println("Gained 20 EXP");
                System.out.println("Congrats! You leveled up!");
                System.out.println("Attack increased by 2!");
                System.out.println("Max Health increased by 5!");
                player.levelUp();
                System.out.println("Congrats! You finished the tutorial!");
            }
        }
        
        if("C".equals(door) || "c".equals(door)){
            Enemy skeleton = new Enemy("Skeleton", 12, 150);
            
            System.out.println("You enter door C to find a human skeleton. Suddenly the skeleton reformed and was equipped with an iron axe and an iron helemet!");
            System.out.println("Your battle with Skeleton started!");
            while(player.getPHp() > 0 && skeleton.getEHp() > 0){
                
                System.out.println("Player HP: " + player.getPHp());
                if(checkCount > 0){
                    System.out.println("Enemy HP: " + skeleton.getEHp());
                }
                
                //The Player's turn is played out with an input and decided based on if else statements.
                
                System.out.println("Select your move: ");
                move = input.next();
                if(move.equals("Attack")){
                    System.out.println("You attacked! You dealt " + power + " points of damage.");
                    skeleton.dealDamage(power);
                } else {
                    if(move.equals("Magic")){
                        if(clas.equals("Warrior")){
                            System.out.println("You charged your sword with a flame of rage and attacked! You dealt 30 points of damage.");
                            skeleton.dealDamage(power * 2);
                        } else {
                            if(clas.equals("Rouge")){
                                System.out.println("You performed a multi stab attack! You dealt 34 points of damage.");
                                skeleton.dealDamage(power * 2);
                            } else {
                                if(clas.equals("Mage")){
                                    System.out.println("You perform a magic fireball attack! You dealt 32 points of damage.");
                                    skeleton.dealDamage(power * 2);
                                } else {
                                    System.out.println("You casted a healing spell on yourself. You regained 15HP.");
                                    player.heal();
                                }
                            }
                        }
                    } else {
                        if(move.equals("Defend")){
                            System.out.println("You entered a defensive pose");
                        } else {
                            if(move.equals("Check")){
                                System.out.println("You gather the stats of your opponet. Max HP is 150 and Attack power is 12");
                            }
                        }
                    }
                }
                
                //The opposing monster has what I like to call "Simple AI", they will only do a basic attack though I plan on changing that and upgrading it in the future.
                System.out.println("The skeleton attacks with a powerful axe attack!");
                if(move.equals("Defend")){
                    System.out.println("Your defensive stance blocked the attack!");
                } else {
                    player.takeDamage(15);
                    System.out.println("You took 12 points of damage!");
                }
            }
            
            //If else statement to determine how o end the game based off of player HP
            if(player.getPHp() <= 0){
                System.out.println("YOU DIED");
                System.out.println("Game Over!");
            } else {
                player.hpReset(health);
                System.out.println("The Skeleton's body began to crumble and fall apart. They quickly turned to dust as he dropped his weapon.");
                System.out.println("You win!");
                System.out.println("Gained 20 EXP");
                System.out.println("Congrats! You leveled up!");
                System.out.println("Attack increased by 2!");
                System.out.println("Max Health increased by 5!");
                player.levelUp();
                System.out.println("Congrats! You finished the tutorial!");
            }
        }
        System.out.println("Note from Dev: Thank you for playing! I hope you enjoyed the game!");
    }
    
}