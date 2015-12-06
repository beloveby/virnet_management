package virnet.management.entity;



/**
 * Courseexp entity. @author MyEclipse Persistence Tools
 */

public class Courseexp  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -8074618767303484139L;
	private Integer courseexpId;
     private Course course;
     private Exp exp;


    // Constructors

    /** default constructor */
    public Courseexp() {
    }

    
    /** full constructor */
    public Courseexp(Integer courseexpId, Course course, Exp exp) {
        this.courseexpId = courseexpId;
        this.course = course;
        this.exp = exp;
    }

   
    // Property accessors

    public Integer getCourseexpId() {
        return this.courseexpId;
    }
    
    public void setCourseexpId(Integer courseexpId) {
        this.courseexpId = courseexpId;
    }

    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    public Exp getExp() {
        return this.exp;
    }
    
    public void setExp(Exp exp) {
        this.exp = exp;
    }
   








}