package virnet.management.entity;



/**
 * UserCharacter entity. @author MyEclipse Persistence Tools
 */

public class UserCharacter  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 7176176678316710388L;
	private Integer userCharacterId;
     private Character character;
     private Integer userCharacterUserId;


    // Constructors

    /** default constructor */
    public UserCharacter() {
    }

    
    /** full constructor */
    public UserCharacter(Integer userCharacterId, Character character, Integer userCharacterUserId) {
        this.userCharacterId = userCharacterId;
        this.character = character;
        this.userCharacterUserId = userCharacterUserId;
    }

   
    // Property accessors

    public Integer getUserCharacterId() {
        return this.userCharacterId;
    }
    
    public void setUserCharacterId(Integer userCharacterId) {
        this.userCharacterId = userCharacterId;
    }

    public Character getCharacter() {
        return this.character;
    }
    
    public void setCharacter(Character character) {
        this.character = character;
    }

    public Integer getUserCharacterUserId() {
        return this.userCharacterUserId;
    }
    
    public void setUserCharacterUserId(Integer userCharacterUserId) {
        this.userCharacterUserId = userCharacterUserId;
    }
   








}