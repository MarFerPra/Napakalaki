#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class DeathBadConsequence < NumericBadConsequence
  def initialize(text)
    super(text,Player::MAXLEVEL,BadConsequence::MAXTREASURES,BadConsequence::MAXTREASURES)
  end
  
  def to_s
  "--- Bad Consequence Muerte --- \n
  Texto: #{@text} \n Niveles: #{@levels} \n
  nVisibles: #{@nVisibleTreasures} \n
  nHidden: #{@nHiddenTreasures} \n"
  end

  public_class_method :new
  
end
