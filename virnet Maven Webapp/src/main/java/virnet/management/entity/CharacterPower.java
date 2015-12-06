package virnet.management.entity;



/**
 * CharacterPower entity. @author MyEclipse Persistence Tools
 */

public class CharacterPower  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 3838194984778030627L;
	private Integer characterPowerId;
     private Character character;
     private Integer characterPowerPowerId;


    // Constructors

    /** default constructor */
    public CharacterPower() {
    }

    
    /** full constructor */
    public CharacterPower(Integer characterPowerId, Character character, Integer characterPowerPowerId) {
        this.characterPowerId = characterPowerId;
        this.character = character;
        this.characterPowerPowerId = characterPowerPowerId;
    }

   
    // Property accessors

    public Integer getCharacterPowerId() {
        return this.characterPowerId;
    }
    
    public void setCharacterPowerId(Integer characterPowerId) {
        this.characterPowerId = characterPowerId;
    }

    public Character getCharacter() {
        return this.character;
    }
    
    public void setCharacter(Character character) {
        this.character = character;
    }

    public Integer getCharacterPowerPowerId() {
        return this.characterPowerPowerId;
    }
    
    public void setCharacterPowerPowerId(Integer characterPowerPowerId) {
        this.characterPowerPowerId = characterPowerPowerId;
    }
   








}