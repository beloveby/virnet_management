package virnet.management.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Exp entity. @author MyEclipse Persistence Tools
 */

public class Exp  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -8807066486645921435L;
	private Integer expId;
     private String expName;
     private String expType;
     private String expStanTime;
     private String expInstruct;
     private String expProfile;
     private Integer expCabinetTempletId;
     private String expRoleTask;
     private Integer expExpTopoId;
     private Integer expExpConfigId;
     private String expCole;
     private Set<?> courseexps = new HashSet<Object>(0);
     private Set<?> classarrangeCases = new HashSet<Object>(0);


    // Constructors

    /** default constructor */
    public Exp() {
    }

	/** minimal constructor */
    public Exp(Integer expId, String expName) {
        this.expId = expId;
        this.expName = expName;
    }
    
    /** full constructor */
    public Exp(Integer expId, String expName, String expType, String expStanTime, String expInstruct, String expProfile, Integer expCabinetTempletId, String expRoleTask, Integer expExpTopoId, Integer expExpConfigId, String expCole, Set<?> courseexps, Set<?> classarrangeCases) {
        this.expId = expId;
        this.expName = expName;
        this.expType = expType;
        this.expStanTime = expStanTime;
        this.expInstruct = expInstruct;
        this.expProfile = expProfile;
        this.expCabinetTempletId = expCabinetTempletId;
        this.expRoleTask = expRoleTask;
        this.expExpTopoId = expExpTopoId;
        this.expExpConfigId = expExpConfigId;
        this.expCole = expCole;
        this.courseexps = courseexps;
        this.classarrangeCases = classarrangeCases;
    }

   
    // Property accessors

    public Integer getExpId() {
        return this.expId;
    }
    
    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    public String getExpName() {
        return this.expName;
    }
    
    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpType() {
        return this.expType;
    }
    
    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getExpStanTime() {
        return this.expStanTime;
    }
    
    public void setExpStanTime(String expStanTime) {
        this.expStanTime = expStanTime;
    }

    public String getExpInstruct() {
        return this.expInstruct;
    }
    
    public void setExpInstruct(String expInstruct) {
        this.expInstruct = expInstruct;
    }

    public String getExpProfile() {
        return this.expProfile;
    }
    
    public void setExpProfile(String expProfile) {
        this.expProfile = expProfile;
    }

    public Integer getExpCabinetTempletId() {
        return this.expCabinetTempletId;
    }
    
    public void setExpCabinetTempletId(Integer expCabinetTempletId) {
        this.expCabinetTempletId = expCabinetTempletId;
    }

    public String getExpRoleTask() {
        return this.expRoleTask;
    }
    
    public void setExpRoleTask(String expRoleTask) {
        this.expRoleTask = expRoleTask;
    }

    public Integer getExpExpTopoId() {
        return this.expExpTopoId;
    }
    
    public void setExpExpTopoId(Integer expExpTopoId) {
        this.expExpTopoId = expExpTopoId;
    }

    public Integer getExpExpConfigId() {
        return this.expExpConfigId;
    }
    
    public void setExpExpConfigId(Integer expExpConfigId) {
        this.expExpConfigId = expExpConfigId;
    }

    public String getExpCole() {
        return this.expCole;
    }
    
    public void setExpCole(String expCole) {
        this.expCole = expCole;
    }

    public Set<?> getCourseexps() {
        return this.courseexps;
    }
    
    public void setCourseexps(Set<?> courseexps) {
        this.courseexps = courseexps;
    }

    public Set<?> getClassarrangeCases() {
        return this.classarrangeCases;
    }
    
    public void setClassarrangeCases(Set<?> classarrangeCases) {
        this.classarrangeCases = classarrangeCases;
    }
   








}