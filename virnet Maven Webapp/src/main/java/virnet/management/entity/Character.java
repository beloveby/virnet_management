package virnet.management.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Character entity. @author MyEclipse Persistence Tools
 */

public class Character  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 3166549152156923809L;
	private Integer characterId;
     private String characterName;
     private String characterInfo;
     private Set<?> characterPowers = new HashSet<Object>(0);
     private Set<?> userCharacters = new HashSet<Object>(0);


    // Constructors

    /** default constructor */
    public Character() {
    }

	/** minimal constructor */
    public Character(Integer characterId) {
        this.characterId = characterId;
    }
    
    /** full constructor */
    public Character(Integer characterId, String characterName, String characterInfo, Set<?> characterPowers, Set<?> userCharacters) {
        this.characterId = characterId;
        this.characterName = characterName;
        this.characterInfo = characterInfo;
        this.characterPowers = characterPowers;
        this.userCharacters = userCharacters;
    }

   
    // Property accessors

    public Integer getCharacterId() {
        return this.characterId;
    }
    
    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return this.characterName;
    }
    
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterInfo() {
        return this.characterInfo;
    }
    
    public void setCharacterInfo(String characterInfo) {
        this.characterInfo = characterInfo;
    }

    public Set<?> getCharacterPowers() {
        return this.characterPowers;
    }
    
    public void setCharacterPowers(Set<?> characterPowers) {
        this.characterPowers = characterPowers;
    }

    public Set<?> getUserCharacters() {
        return this.userCharacters;
    }
    
    public void setUserCharacters(Set<?> userCharacters) {
        this.userCharacters = userCharacters;
    }
   








}