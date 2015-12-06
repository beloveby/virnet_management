package virnet.management.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -7999573583615976144L;
	private Integer courseId;
     private String courseName;
     private Integer courseTeacherId;
     private Set<?> courseexps = new HashSet<Object>(0);
     private Set<?> classes = new HashSet<Object>(0);


    // Constructors

    /** default constructor */
    public Course() {
    }

	/** minimal constructor */
    public Course(Integer courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }
    
    /** full constructor */
    public Course(Integer courseId, String courseName, Integer courseTeacherId, Set<?> courseexps, Set<?> classes) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTeacherId = courseTeacherId;
        this.courseexps = courseexps;
        this.classes = classes;
    }

   
    // Property accessors

    public Integer getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseTeacherId() {
        return this.courseTeacherId;
    }
    
    public void setCourseTeacherId(Integer courseTeacherId) {
        this.courseTeacherId = courseTeacherId;
    }

    public Set<?> getCourseexps() {
        return this.courseexps;
    }
    
    public void setCourseexps(Set<?> courseexps) {
        this.courseexps = courseexps;
    }

    public Set<?> getClasses() {
        return this.classes;
    }
    
    public void setClasses(Set<?> classes) {
        this.classes = classes;
    }
   








}