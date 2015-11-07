package napakalaki;

import java.util.ArrayList;

public class Player {
 
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    
    public Player(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    private void bringToLife(){
        this.dead = false;
    }
    
    private int getCombatLevel(){
        return this.level;
    }
    
    private void incrementLevels(int l){
        
    }
    
    private void decrementLevels(int l){
        
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        return false;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        return 0;
    }
    
    private void dieIfNoTreasures(){
        
    }
    
    public boolean isDead(){
        return this.dead;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return null;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return null;
    }
    
    public CombatResult combat(Monster m){
        return null;
    }
    
    public void makeTreasureVisible(Treasure t){
        
    }
    
    public void discardVisibleTreasure(Treasure t){
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
    }
    
    public boolean validState(){
        return false;
    }
    
    public void initTreasures(){
        
    }
    
    public int getLevels(){
        return 0;
    }
    
    public Treasure stealTreasure(){
        return null;
    }
    
    public void setEnemy(Player enemy){
        
    }
    
    private Treasure giveMeATreasure(){
        return null;
    }
    
    public boolean canISteal(){
        return this.canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        return false;
    }
    
    private void haveStolen(){
        
    }
    
    public void discardAllTreasures(){
        
    }
    
}