/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package napakalaki;

import java.util.ArrayList;

public class Napakalaki {
    
    Monster currentMonster = null;
    CardDealer dealer = null;
    Player currentPlayer = null;
    ArrayList<Player> players = null;
    
    private static final Napakalaki instance = new Napakalaki();
    
    private Napakalaki(){
        
        dealer = CardDealer.getInstance();
        players = new ArrayList();
        
    };
    
    private void initPlayers(ArrayList<String> names){
        
    }
    
    private Player nextPlayer(){
        return null;
    }
    
    private boolean nextTurnAllowed(){
        return false;
    }
    
    private void setEnemies(){}
    
    public static Napakalaki getInstance(){
        return instance;
    }

    public CombatResult developCombat(){
        return null;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
    }    
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
    }
    
    public void initGame(ArrayList<String> players){
        
    }
    
    public Player getCurrentPlayer(){
        return null;
    }
    
    public Monster getCurrentMonster(){
        return null;
    }
    
    public boolean nextTurn(){
        return false;
    }
    
    public boolean endOfGame(CombatResult result){
        return false;
    }
    
    
    public static void main(String[] args) {
        
        ArrayList<Monster> monstruos = new ArrayList();
        BadConsequence bc;
        Prize prize;
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        
        // El Rey de Rosa
       bc = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
       prize = new Prize(4,2);
       monstruos.add(new Monster("El rey de rosa", 13, bc, prize));
       
       // Ángeles de la noche ibicenca
 
       tVisible.add(TreasureKind.ONEHAND);
       tHidden.add(TreasureKind.ONEHAND);
       bc = new BadConsequence("Tatrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. "
               + "Descarta 1 mano visible y 1 mano oculta.", 0, tVisible, tHidden);
       prize = new Prize(4,1);
       monstruos.add(new Monster("Angeles de la noche ibicenca", 14, bc, prize));
       
       tVisible = new ArrayList();
       tHidden = new ArrayList();
       
       // 3 Byakhees de bonanza
       tVisible.add(TreasureKind.ARMOR);
       tHidden.add(TreasureKind.ARMOR);
       bc = new BadConsequence("Pierdes tu armadura visible y otra oculta.",0,tVisible,tHidden);
       prize = new Prize(2,1);
       monstruos.add(new Monster("3 Byakhees de bonanza",8,bc,prize));
       
       tVisible = new ArrayList();
       tHidden = new ArrayList();
       
       // Chibithulhu
       tVisible.add(TreasureKind.HELMET);
       bc = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.",
       0,tVisible,null);
       prize = new Prize(1,1);
       monstruos.add(new Monster("Chibithulhu",2,bc,prize));
       
       tVisible = new ArrayList();
       
       // El sopor de Dunwich
       tVisible.add(TreasureKind.SHOES);
       bc = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.",0,tVisible,null);
       prize = new Prize(1,1);
       monstruos.add(new Monster("El sopor de Dunwich",2,bc,prize));
       
       tVisible = new ArrayList();
       
       // El gorrón en el umbral
       
       tVisible.add(TreasureKind.ARMOR);
       tVisible.add(TreasureKind.BOTHHANDS);
       tVisible.add(TreasureKind.HELMET);
       tVisible.add(TreasureKind.ONEHAND);
       tVisible.add(TreasureKind.SHOES);
       bc = new BadConsequence("Pierdes todos tus tesoros visibles.",0,tVisible,null);
       prize = new Prize(3,1);
       monstruos.add(new Monster("El gorrón en el umbral",10,bc,prize));
       
       tVisible = new ArrayList();
       
       // H.P Munchcraft
       
       tVisible.add(TreasureKind.ARMOR);
       bc = new BadConsequence("Pierdes la armadura visible.",0,tVisible,null);
       prize = new Prize(2,1);
       monstruos.add(new Monster("H.P. Munchcraft",6,bc,prize));
       
       tVisible = new ArrayList();
       
       // Bichgooth
       
       tVisible.add(TreasureKind.ARMOR);
       bc = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,tVisible,null);
       prize = new Prize(1,1);
       monstruos.add(new Monster("Bichgooth",2,bc,prize));
       
       tVisible = new ArrayList();
       
       // La que redacta en las tinieblas
       
       bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2,0,0);
       prize = new Prize(1,1);
       monstruos.add(new Monster("La que redacta en las tinieblas",2,bc,prize));
       
       // Los hondos
       
       bc = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.",true);
       prize = new Prize(2,1);
       monstruos.add(new Monster("Los hondos",8,bc,prize));
       
       // Semillas Cthulhu
       
       bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.",2,0,2);
       prize = new Prize(2,1);
       monstruos.add(new Monster("Semillas Cthulhu",4,bc,prize));
       
       // Dameargo
       
       tVisible.add(TreasureKind.ONEHAND);
       bc = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,tVisible,null);
       prize = new Prize(2,1);
       monstruos.add(new Monster("Dameargo",1,bc,prize));
       
       tVisible = new ArrayList();
       
       // Pollipólipo volante
       
       bc = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
       prize = new Prize(1,1);
       monstruos.add(new Monster("Pollipólipo volante",3,bc,prize));
       
       // Yskhtihyssg-Goth
       
       bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto",true);
       prize = new Prize(3,1);
       monstruos.add(new Monster("Yskhtihyssg-Goth",12,bc,prize));
       
       // Familia feliz
       
       bc = new BadConsequence("La familia te atrapa. Estás muerto",true);
       prize = new Prize(4,1);
       monstruos.add(new Monster("Familia feliz",1,bc,prize));
       
       // Roboggoth
       tVisible.add(TreasureKind.BOTHHANDS);
       bc = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de las dos manos visible.",2,tVisible,null);
       prize = new Prize(2,1);
       monstruos.add(new Monster("Roboggoth",8,bc,prize));
       
       tVisible = new ArrayList();
       
       // El espia
       
       tVisible.add(TreasureKind.HELMET);
       bc = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.",0,tVisible,null);
       prize = new Prize(1,1);
       monstruos.add(new Monster("El espia",5,bc,prize));
       
       tVisible = new ArrayList();
       
       // El lenguas
       
       bc = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
       prize = new Prize(1,1);
       monstruos.add(new Monster("El lenguas",20,bc,prize));
       
       // Bicéfalo
       tVisible.add(TreasureKind.BOTHHANDS);
       bc = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las dos manos.",3,tVisible,null);
       prize = new Prize(1,1);
       monstruos.add(new Monster("Bicéfalo",20,bc,prize));
       
       tVisible = new ArrayList();
       
       //System.out.println(monstruos.get(0).toString());
       //System.out.println(monstruos.get(2).toString());
       gananciaNivelesSuperiorA1(monstruos);
       perdidaEspecificaTesoros(monstruos);
       
       
       ArrayList<Treasure> tesoros = new ArrayList();
       Treasure tesoro = new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Botas de investigación", 3, TreasureKind.SHOES);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("A prueba de balas", 2, TreasureKind.ARMOR);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS); // ¿ BOTHHANDS ?
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Casco minero", 2, TreasureKind.HELMET);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Fez alópodo", 3, TreasureKind.HELMET);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Gaita", 4, TreasureKind.BOTHHANDS);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Insecticida", 2, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Garabato místico", 2, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Necrocomicón", 1, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Necrognomicón", 2, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Necrotelecom", 2, TreasureKind.HELMET);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Necroplayboycón", 3, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Porra prenatural", 2, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET);
       tesoros.add(tesoro);
       
       tesoro = new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES);
       tesoros.add(tesoro);
    }
    

    static public void nivelSuperiorA10(ArrayList<Monster> monstruos){
       System.out.println("--- Monstruos con nivel de combate superior a 10 --- \n");
       for(Monster monstruo: monstruos){
           if(monstruo.getCombatLevel() > 10){
               System.out.println(monstruo.toString());
           }
       }
    }
    
    static public void malRolloPerdidaNiveles(ArrayList<Monster> monstruos){
        System.out.println("--- Monstruos con mal rollo de pérdida de niveles --- \n");
        for(Monster monstruo: monstruos){
            BadConsequence bc = monstruo.getBadConsequence();
            if(bc.getLevels() != 0 && !bc.isDeath() && bc.getNHiddenTreasures() == 0 && bc.getNVisibleTreasures() == 0
                    && bc.getSpecificHiddenTreasures() == null && bc.getSpecificVisibleTreasures() == null)
            {
                System.out.println(monstruo.toString());
            }
        }
    }
    
    static public void gananciaNivelesSuperiorA1(ArrayList<Monster> monstruos){
        System.out.println("--- Monstruos con ganancia de niveles superior a 1 --- \n");
        for(Monster monstruo: monstruos){
            if(monstruo.getPrize().getLevel() > 1){
                System.out.println(monstruo.toString());
            }
        }
    }
    
    static public void perdidaEspecificaTesoros(ArrayList<Monster> monstruos){
        System.out.println("--- Monstruos con pérdidas específicas de tesoros --- \n");
        for (Monster monstruo : monstruos) {
            BadConsequence bc = monstruo.getBadConsequence();
            if (bc.getLevels() == 0 && !bc.isDeath() && bc.getNHiddenTreasures() == 0 && bc.getNVisibleTreasures() == 0
                   && (bc.getSpecificHiddenTreasures() != null || bc.getSpecificVisibleTreasures() != null)) {
                System.out.println(monstruo.toString());
            }
        }
    }
    
    
    
    
    
}
