package com.pancost.table;

import java.util.ArrayList;

/**
 * A resource table which can hold data indexed as shown in any standard RPG rule book.
 * @author Brandon Pancost
 * @since 1/10/11
 */
public class ResourceTable extends ArrayList{
    int dice = 1;
    int sides;
    boolean totalFlag = true;
    int maxIndex = 1;
    int minIndex = 0;
    int modifier = 0;
    
    /**
     * Initializes the resource table with full control over its behavior.
     * @param dice The number of dice used by the index.
     * @param sides The number sides on the dice used by the index.
     * @param totalFlag The mode of the table. True if rolling for totals, false if rolling side by side.
     */
    public ResourceTable(int dice, int sides, boolean totalFlag){
        super();
        this.dice = dice;
        this.sides = sides;
        this.totalFlag = totalFlag;
        if(totalFlag){
            maxIndex = dice*sides;
            minIndex = dice;
            ensureCapacity(minIndex);
        }else{
            assert sides < 10;//I figure there is no reason to use this over 10
            //so why bother getting lost in calculation over nothing?
            ensureCapacity(dice+sides);
            String textValue = "";
            for(int i = 0; i < dice; i++){
                textValue += sides;
            }
            maxIndex = Integer.parseInt(textValue);
        }
    }
    
    /**
     * Initializes a resource table that assumes all rolls are summed, not side by side.
     * @param dice The number of dice used by the index.
     * @param sides The number sides on the dice used by the index.
     * @param modifier
     */
    public ResourceTable(int dice, int sides, int modifier){
        super();
        this.dice = dice;
        this.sides = sides;
        this.modifier = modifier;
        maxIndex = (dice*sides)-modifier;
        minIndex = dice-modifier;
        ensureCapacity(maxIndex);
    }
    
    /**
     * Initializes a resource table that assumes all rolls are summed, not side by side.
     * @param dice The number of dice used by the index.
     * @param sides The number sides on the dice used by the index.
     */
    public ResourceTable(int dice, int sides){
        super();
        this.dice = dice;
        this.sides = sides;
        maxIndex = dice*sides;
        minIndex = dice;
        ensureCapacity(maxIndex);
    }
    
    /**
     * Initializes a resource table that is assumed to use only a single die in its index.
     * @param sides The number sides on the single die used by the index.
     */
    public ResourceTable(int sides){
        super();
        this.sides = sides;
        minIndex = 1;
        maxIndex = sides;
        ensureCapacity(maxIndex);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int size(){
        return maxIndex;
    }
    
    /**
     * 
     * @param index
     * @param element 
     */
    @Override
    public void add(int index, Object element){
        assert index <= maxIndex;
        assert index >= minIndex;
        if(totalFlag){
            super.add(index-1, element);
        }else{
            int realIndex = sideBySideRealIndexCalculator(index);
            super.add(realIndex, element);
        }
    }
    
    /**
     * 
     * @param index
     * @return 
     */
    @Override
    public Object get(int index){
        assert index <= maxIndex;
        assert index >= minIndex;
        if(totalFlag){
            return super.get(index-1);
        }else{
            int realIndex = sideBySideRealIndexCalculator(index);
            return super.get(realIndex);
        }
    }
    
    /**
     * 
     * @param index
     * @param element
     * @return 
     */
    @Override
    public Object set(int index, Object element){
        assert index <= maxIndex;
        assert index >= minIndex;
        if(totalFlag){
            return super.set(index-1, element);
        }else{
            int realIndex = sideBySideRealIndexCalculator(index);
            return super.set(realIndex, element);
        }
    }
    
    /**
     * 
     * @param index
     * @return 
     */
    @Override
    public Object remove(int index){
        assert index <= maxIndex;
        assert index >= minIndex;
        if(totalFlag){
            return super.remove(index-1);
        }else{
            int realIndex = sideBySideRealIndexCalculator(index);
            return super.remove(realIndex);
        }
    }
    
    /**
     * Shows if the table is setup for total rolls from dice (or side by side).
     * @return Returns true if dice should roll for a total (e.g. 2d6) instead of side by side (e.g. d66).
     */
    public boolean isRollTotal(){
        return totalFlag;
    }

    /**
     * Determines the internal index of a side by side dice roll index.
     * @param index A side by side die roll index (such as a d66 index)
     * @return The internal ArrayList index.
     */
    private int sideBySideRealIndexCalculator(int index){
        int realIndex = 0;
        String sindex = "" + index;
        sindex.length();
        char[] cindex = sindex.toCharArray();
        int digitNumber = 1;
        for(int i = cindex.length - 1; i >= 0; i++){
            int currentDigit = Integer.parseInt(""+cindex[i]);
            realIndex += currentDigit*digitNumber;
            digitNumber++;
        }
        return realIndex;
    }
    
}
