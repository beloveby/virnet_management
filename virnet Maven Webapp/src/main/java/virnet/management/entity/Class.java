package virnet.management.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class Class  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -2448892750756691074L;
	private Integer classId;
     private Course course;
     private String className;
     private Integer classTeacherId;
     private Set<?> periodarranges = new HashSet<Object>(0);
     private Set<?> stuClasses = new HashSet<Object>(0);


    // Constructors

    /** default constructor */
    public Class() {
    }

	/** minimal constructor */
    public Class(Integer classId, Course course) {
        this.classId = classId;
        this.course = course;
    }
    
    /** full constructor */
    public Class(Integer classId, Course course, String className, Integer classTeacherId, Set<?> periodarranges, Set<?> stuClasses) {
        this.classId = classId;
        this.course = course;
        this.className = className;
        this.classTeacherId = classTeacherId;
        this.periodarranges = periodarranges;
        this.stuClasses = stuClasses;
    }

   
    // Property accessors

    public Integer getClassId() {
        return this.classId;
    }
    
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassTeacherId() {
        return this.classTeacherId;
    }
    
    public void setClassTeacherId(Integer classTeacherId) {
        this.classTeacherId = classTeacherId;
    }

    public Set<?> getPeriodarranges() {
        return this.periodarranges;
    }
    
    public void setPeriodarranges(Set<?> periodarranges) {
        this.periodarranges = periodarranges;
    }

    public Set<?> getStuClasses() {
        return this.stuClasses;
    }
    
    public void setStuClasses(Set<?> stuClasses) {
        this.stuClasses = stuClasses;
    }
   








}