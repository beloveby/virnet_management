package virnet.management.entity;



/**
 * StuClass entity. @author MyEclipse Persistence Tools
 */

public class StuClass  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -1792819498611549514L;
	private Integer stuClassId;
     private Class Class;
     private Integer stuClassUserId;


    // Constructors

    /** default constructor */
    public StuClass() {
    }

    
    /** full constructor */
    public StuClass(Integer stuClassId, Class Class, Integer stuClassUserId) {
        this.stuClassId = stuClassId;
        this.Class = Class;
        this.stuClassUserId = stuClassUserId;
    }

   
    // Property accessors

    public Integer getStuClassId() {
        return this.stuClassId;
    }
    
    public void setStuClassId(Integer stuClassId) {
        this.stuClassId = stuClassId;
    }

    public Class getclass() {
        return this.Class;
    }
    
    public void setclass(Class Class) {
        this.Class = Class;
    }

    public Integer getStuClassUserId() {
        return this.stuClassUserId;
    }
    
    public void setStuClassUserId(Integer stuClassUserId) {
        this.stuClassUserId = stuClassUserId;
    }
   








}