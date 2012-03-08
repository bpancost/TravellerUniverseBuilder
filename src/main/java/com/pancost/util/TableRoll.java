package com.pancost.util;

import com.pancost.dice.Dice;
import com.pancost.table.ResourceTable;

/**
 * TableRoll is supplied a table and dice and gives the result of a random table
 * lookup based off of the set rules.
 * @author Brandon Pancost
 * @since 1/10/11
 */
public class TableRoll {
    ResourceTable table;
    Dice dice;
    //TODO Perhaps I should wrap this all into the ResourceTable?
    //It would make it more verifiable, but less flexible.
    /**
     * Creates a table roller which can be used to get a random entry from a
     * resource table using the appropriate dice in the correct style for the table.
     * @param table The ResourceTable which holds the data.
     * @param dice The Dice which will be used to randomly pick the entries.
     */
    public TableRoll(ResourceTable table, Dice dice){
        this.table = table;
        this.dice = dice;
    }
    
    /**
     * Gets a random entry from the given table using the index from the supplied dice.
     * @return A random entry from the table.
     */
    public Object getRandomEntry(){
        if(table.isRollTotal()){
            return table.get(dice.rollTotal());
        }else{
            return table.get(dice.rollSideBySide());
        }
    }
}
