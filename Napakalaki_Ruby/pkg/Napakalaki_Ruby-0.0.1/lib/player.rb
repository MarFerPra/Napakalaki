#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

require_relative 'dice'
require_relative 'combat_result'

class Player
  
  MAXLEVEL = 10
  
  def initialize(name, p = nil)
    if(p.nil?)
      @name = name
      @level = 1
      @dead = true
      @canISteal = true
      @enemy = nil
      @visibleTreasures = Array.new
      @hiddenTreasures = Array.new
      @pendingBadConsequence = nil
    else
      @name = p.name
      @level = p.level
      @visibleTreasures = p.visibleTreasures
      @hiddenTreasures = p.hiddenTreasures
      @pendingBadConsequence = p.pendingBadConsequence
      @dead = p.dead
      @canISteal = p.canISteal
      @enemy = p.enemy
    end

  end

  attr_reader :name,:level,:canISteal,:dead,:hiddenTreasures,:visibleTreasures, :pendingBadConsequence, :enemy
  attr_writer :pendingBadConsequence, :enemy
  
  def getOponentLevel(m)
    return m.combatLevel
  end
  
  def shouldConvert()
    return (Dice.instance.nextNumber == 1)
  end
  
  def getCombatLevel()
    
    combat_level = @level
    
    for treasure in @visibleTreasures
      combat_level+=treasure.bonus
    end
    
    return combat_level
  end
  
  def bringToLife()
    @dead = false
  end

  def incrementLevels(i)
    @level+=i
  end
  
  def decrementLevels(i)
    if(i>=@level)
      @level = 1
    else
      @level -= i
    end
  end
  
  def applyPrize(m)
    nLevels = m.getLevelsGained()
    incrementLevels(nLevels)
    nTreasures = m.getTreasuresGained()
    if(nTreasures > 0)
      i=0
      loop do
        i+=1
        t = CardDealer.instance.nextTreasure
        @hiddenTreasures << t
        break if i==nTreasures
      end
    end
  end
  
  def applyBadConsequence(m)
    bc = m.bc
    decrementLevels(bc.levels)
    pendingBad = bc.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
    @pendingBadConsequence = pendingBad
  end
  
  def canMakeTreasureVisible(t)
    tipo = t.tkind
    # Si es ARMOR
    if(tipo == TreasureKind::ARMOR)
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::ARMOR)
          return false
        end
      end
        return true
      
    # Si es ONEHAND
    elsif(tipo == TreasureKind::ONEHAND)
      numUnaMano = 0
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::ONEHAND)
          numUnaMano+=1;
        end
      end
      return (numUnaMano <= 1)
    
    # Si es BOTHHANDS
    elsif(tipo == TreasureKind::BOTHHANDS)
      numUnaMano = 0
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::ONEHAND || treasure.tkind == TreasureKind::BOTHHANDS)
          return false
        end
      end
      return true
     
    # Si es HELMET
    elsif(tipo == TreasureKind::HELMET)
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::HELMET)
          return false
        end
      end
      return true
      
    #Si es SHOE
    else
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::SHOES)
          return false
        end
      end
      return true
    end
  end
  
  def dieIfNoTreasures()
    
    if(@visibleTreasures.empty? && @hiddenTreasures.empty?)
      @dead = true
    end
    
  end
  
  def combat(m)
    myLevel = getCombatLevel()
    monsterLevel = getOponentLevel(m)
    
    if(myLevel > monsterLevel)
      applyPrize(m)
      if(myLevel >= MAXLEVEL)
        return CombatResult::WINGAME
      else
        return CombatResult::WIN
      end
    else
      applyBadConsequence(m)
      if(shouldConvert())
        return CombatResult::LOSEANDCONVERT
      else
        return CombatResult::LOSE
      end
    end
  end
  
  def makeTreasureVisible(t)
    canI = canMakeTreasureVisible(t)
    if(canI)
      @visibleTreasures << t
      @hiddenTreasures.delete(t)
    end
  end

  def discardVisibleTreasure(t)
    if(@visibleTreasures != nil)
      @visibleTreasures.delete(t)
      if(@pendingBadConsequence != nil)
        @pendingBadConsequence.substractVisibleTreasure(t)
      end
      dieIfNoTreasures()
    end
  end
  
  def discardHiddenTreasure(t)
    if(@hiddenTreasures != nil)
      @hiddenTreasures.delete(t)
      if(@pendingBadConsequence != nil)
        @pendingBadConsequence.substractHiddenTreasure(t)
      end
      dieIfNoTreasure()
    end
  end
  
  def validState()
    if(@pendingBadConsequence.isEmpty() || @hiddenTreasures.size<=4)
      return true
    end
    return false
  end
  
  def howManyVisibleTreasures(tKind)
    contador = 0
    for tesoro in @visibleTreasures
      if(tesoro.tkind == tKind)
        contador = contador + 1
      end
    end
    return contador
  end
  
  def initTreasures()
    dealer = CardDealer.instance
    dice = Dice.instance
    
    bringToLife()
    
    t = dealer.nextTreasure
    @hiddenTreasures << t
    number = dice.nextNumber
    
    if(number > 1)
      t = dealer.nextTreasure
      @hiddenTreasures << t
    end
    
    if(number > 6)
      t = dealer.nextTreasure
      @hiddenTreasures << t
    end
    
  end
  
  def stealTreasure()
    canI = canISteal()
    if(canI)
      canYou = @enemy.canYouGiveMeATreasure()
      if(canYou)
        tesoroRobado = @enemy.giveMeATreasure()
        @hiddenTreasures << tesoroRobado
        haveStolen()
        return tesoroRobado
      end
    end
    return nil
  end
  
  def giveMeATreasure()
    return @hiddenTreasures[rand(@hiddenTreasures.size-1)]
  end
  
  def canYouGiveMeATreasure()
    if( @hiddenTreasures != nil || ! @hiddenTreasures.empty?)
      return true
    end
    return false
  end
  
  def haveStolen()
    @canISteal = false
  end
  
  def discardAllTreasures()
    tVisibles = @visibleTreasures.clone
    tHidden = @hiddenTreasures.clone
    
    for vt in tVisibles
      discardVisibleTreasure(vt)
    end
    
    for ht in tHidden
      discardHiddenTreasure(ht)
    end
    
  end
  
  def to_s
    "#{@name}(#{getCombatLevel()}) \n"
  end
  
end
