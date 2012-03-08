package com.pancost.dice;

/**
 * The Dice class gives the ability to roll any number of arbitrarily sided dice,
 * with an optional modifier value.
 * @author Brandon Pancost
 * @since 1/10/11
 */
public class Dice {
    int number = 1;
    int sides;
    int modifier = 0;
    
    /**
     * Creates any number of dice with a set number of sides along with
     * a modifier to be added to any die rolls.
     * @param number The number of dice.
     * @param sides The number of sides on the dice.
     * @param modifier The modifier to add to any die roll totals.
     */
    public Dice(int number, int sides, int modifier){
        this.number = number;
        this.sides = sides;
        this.modifier = modifier;
    }
    
    /**
     * Creates any number of dice with a set number of sides.
     * @param number The number of dice.
     * @param sides The number of sides on the dice.
     */
    public Dice(int number, int sides){
        this.number = number;
        this.sides = sides;
    }
    
    /**
     * Creates one die with any number of sides.
     * @param sides The number of sides on the die.
     */
    public Dice(int sides){
        this.sides = sides;
    }
    
    /**
     * Rolls the current dice one by one and adds up the total.
     * The modifier is then added to the total and the resulting value is returned.
     * @return The total from the die rolls + the modifier.
     */
    public int rollTotal(){
        int total = 0;
        for(int i = 0; i < number; i++){
            total += Math.floor(Math.random()*sides)+1;
        }
        return (total + modifier);
    }
    
    /**
     * Rolls the current dice side by side (for example d66)
     * @return Returns the results of each die side by side in integer form
     */
    public int rollSideBySide(){
        String result = "";
        for(int i = 0; i < number; i++){
            int temp = (int) Math.floor(Math.random()*sides)+1;
            result += temp;
        }
        return Integer.parseInt(result);
    }
    
    /**
     * For quickly rolling a specified number of dice with a set number of sides.
     * @param number The number of dice.
     * @param sides The number of sides on the dice.
     * @return The total of the die rolls plus the modifier.
     */
    public static int quickRoll(int number, int sides){
        return quickRoll(number, sides, 0);
    }
    /**
     * For quickly rolling a specified number of dice with a set number of sides
     * plus some modifier (positive or negative).
     * @param number The number of dice.
     * @param sides The number of sides on the dice.
     * @param modifier The modifier to add to any die roll totals.
     * @return The total of the die rolls plus the modifier.
     */
    public static int quickRoll(int number, int sides, int modifier){
        int total = 0;
        for(int i = 0; i < number; i++){
            total += (int) Math.floor(Math.random()*sides)+1;
        }
        return (total + modifier);
    }
    
    public static int rolld2(){
        return (int) Math.floor(Math.random()*2)+1;
    }
    
    public static int rolld4(){
        return (int) Math.floor(Math.random()*4)+1;
    }
    
    public static int rolld6(){
        return (int) Math.floor(Math.random()*6)+1;
    }
    
    public static int rolld66(){
        String result = "";
        for(int i = 0; i < 2; i++){
            int temp = (int) Math.floor(Math.random()*6)+1;
            result += temp;
        }
        return Integer.parseInt(result);
    }
    
    public static int roll2d6(){
        int total = 0;
        for(int i = 0; i < 2; i++){
            total += (int) Math.floor(Math.random()*6)+1;
        }
        return (total);
    }
    
    public static int rolld8(){
        return (int) Math.floor(Math.random()*8)+1;
    }
    
    public static int rolld12(){
        return (int) Math.floor(Math.random()*12)+1;
    }
    
    public static int rolld20(){
        return (int) Math.floor(Math.random()*20)+1;
    }
}
