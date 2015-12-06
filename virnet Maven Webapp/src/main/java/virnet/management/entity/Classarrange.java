package virnet.management.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Classarrange entity. @author MyEclipse Persistence Tools
 */

public class Classarrange  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 9220110823518690730L;
	private Integer classarrangeId;
     private Periodarrange periodarrange;
     private Integer classarrangeStartClassOrder;
     private Integer classarrangeClassNum;
     private String classarrangeName;
     private Short classarrangeUnited;
     private String classarrangeStartOrderDate;
     private String classarrangeStartOrderTime;
     private String classarrangeEndOrderDate;
     private String classarrangeEndOrderTime;
     private Set<?> classarrangeCases = new HashSet<Object>(0);


    // Constructors

    /** default constructor */
    public Classarrange() {
    }

	/** minimal constructor */
    public Classarrange(Integer classarrangeId, Periodarrange periodarrange, Integer classarrangeStartClassOrder) {
        this.classarrangeId = classarrangeId;
        this.periodarrange = periodarrange;
        this.classarrangeStartClassOrder = classarrangeStartClassOrder;
    }
    
    /** full constructor */
    public Classarrange(Integer classarrangeId, Periodarrange periodarrange, Integer classarrangeStartClassOrder, Integer classarrangeClassNum, String classarrangeName, Short classarrangeUnited, String classarrangeStartOrderDate, String classarrangeStartOrderTime, String classarrangeEndOrderDate, String classarrangeEndOrderTime, Set<?> classarrangeCases) {
        this.classarrangeId = classarrangeId;
        this.periodarrange = periodarrange;
        this.classarrangeStartClassOrder = classarrangeStartClassOrder;
        this.classarrangeClassNum = classarrangeClassNum;
        this.classarrangeName = classarrangeName;
        this.classarrangeUnited = classarrangeUnited;
        this.classarrangeStartOrderDate = classarrangeStartOrderDate;
        this.classarrangeStartOrderTime = classarrangeStartOrderTime;
        this.classarrangeEndOrderDate = classarrangeEndOrderDate;
        this.classarrangeEndOrderTime = classarrangeEndOrderTime;
        this.classarrangeCases = classarrangeCases;
    }

   
    // Property accessors

    public Integer getClassarrangeId() {
        return this.classarrangeId;
    }
    
    public void setClassarrangeId(Integer classarrangeId) {
        this.classarrangeId = classarrangeId;
    }

    public Periodarrange getPeriodarrange() {
        return this.periodarrange;
    }
    
    public void setPeriodarrange(Periodarrange periodarrange) {
        this.periodarrange = periodarrange;
    }

    public Integer getClassarrangeStartClassOrder() {
        return this.classarrangeStartClassOrder;
    }
    
    public void setClassarrangeStartClassOrder(Integer classarrangeStartClassOrder) {
        this.classarrangeStartClassOrder = classarrangeStartClassOrder;
    }

    public Integer getClassarrangeClassNum() {
        return this.classarrangeClassNum;
    }
    
    public void setClassarrangeClassNum(Integer classarrangeClassNum) {
        this.classarrangeClassNum = classarrangeClassNum;
    }

    public String getClassarrangeName() {
        return this.classarrangeName;
    }
    
    public void setClassarrangeName(String classarrangeName) {
        this.classarrangeName = classarrangeName;
    }

    public Short getClassarrangeUnited() {
        return this.classarrangeUnited;
    }
    
    public void setClassarrangeUnited(Short classarrangeUnited) {
        this.classarrangeUnited = classarrangeUnited;
    }

    public String getClassarrangeStartOrderDate() {
        return this.classarrangeStartOrderDate;
    }
    
    public void setClassarrangeStartOrderDate(String classarrangeStartOrderDate) {
        this.classarrangeStartOrderDate = classarrangeStartOrderDate;
    }

    public String getClassarrangeStartOrderTime() {
        return this.classarrangeStartOrderTime;
    }
    
    public void setClassarrangeStartOrderTime(String classarrangeStartOrderTime) {
        this.classarrangeStartOrderTime = classarrangeStartOrderTime;
    }

    public String getClassarrangeEndOrderDate() {
        return this.classarrangeEndOrderDate;
    }
    
    public void setClassarrangeEndOrderDate(String classarrangeEndOrderDate) {
        this.classarrangeEndOrderDate = classarrangeEndOrderDate;
    }

    public String getClassarrangeEndOrderTime() {
        return this.classarrangeEndOrderTime;
    }
    
    public void setClassarrangeEndOrderTime(String classarrangeEndOrderTime) {
        this.classarrangeEndOrderTime = classarrangeEndOrderTime;
    }

    public Set<?> getClassarrangeCases() {
        return this.classarrangeCases;
    }
    
    public void setClassarrangeCases(Set<?> classarrangeCases) {
        this.classarrangeCases = classarrangeCases;
    }
   








}