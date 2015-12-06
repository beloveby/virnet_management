package virnet.management.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Periodarrange entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Periodarrange  implements java.io.Serializable {


    // Fields    

     private Integer periodarrangeId;
     private Class Class;
     private Integer periodarrangeCabinetNum;
     private Date periodarrangeStartDate;
     private Integer periodarrangeStartTime;
     private Date periodarrangeEndDate;
     private Integer periodarrangeEndTime;
     private Integer periodarrangeAllClassNum;
     private Integer periodarrangeSetUpUserId;
     private Set<?> classarranges = new HashSet<Object>(0);


    // Constructors

    /** default constructor */
    public Periodarrange() {
    }

	/** minimal constructor */
    public Periodarrange(Integer periodarrangeId, Class Class, Date periodarrangeStartDate, Integer periodarrangeStartTime, Integer periodarrangeSetUpUserId) {
        this.periodarrangeId = periodarrangeId;
        this.Class = Class;
        this.periodarrangeStartDate = periodarrangeStartDate;
        this.periodarrangeStartTime = periodarrangeStartTime;
        this.periodarrangeSetUpUserId = periodarrangeSetUpUserId;
    }
    
    /** full constructor */
    public Periodarrange(Integer periodarrangeId, Class Class, Integer periodarrangeCabinetNum, Date periodarrangeStartDate, Integer periodarrangeStartTime, Date periodarrangeEndDate, Integer periodarrangeEndTime, Integer periodarrangeAllClassNum, Integer periodarrangeSetUpUserId, Set<?> classarranges) {
        this.periodarrangeId = periodarrangeId;
        this.Class = Class;
        this.periodarrangeCabinetNum = periodarrangeCabinetNum;
        this.periodarrangeStartDate = periodarrangeStartDate;
        this.periodarrangeStartTime = periodarrangeStartTime;
        this.periodarrangeEndDate = periodarrangeEndDate;
        this.periodarrangeEndTime = periodarrangeEndTime;
        this.periodarrangeAllClassNum = periodarrangeAllClassNum;
        this.periodarrangeSetUpUserId = periodarrangeSetUpUserId;
        this.classarranges = classarranges;
    }

   
    // Property accessors

    public Integer getPeriodarrangeId() {
        return this.periodarrangeId;
    }
    
    public void setPeriodarrangeId(Integer periodarrangeId) {
        this.periodarrangeId = periodarrangeId;
    }

    public Class getclass() {
        return this.Class;
    }
    
    public void setclass(Class Class) {
        this.Class = Class;
    }

    public Integer getPeriodarrangeCabinetNum() {
        return this.periodarrangeCabinetNum;
    }
    
    public void setPeriodarrangeCabinetNum(Integer periodarrangeCabinetNum) {
        this.periodarrangeCabinetNum = periodarrangeCabinetNum;
    }

    public Date getPeriodarrangeStartDate() {
        return this.periodarrangeStartDate;
    }
    
    public void setPeriodarrangeStartDate(Date periodarrangeStartDate) {
        this.periodarrangeStartDate = periodarrangeStartDate;
    }

    public Integer getPeriodarrangeStartTime() {
        return this.periodarrangeStartTime;
    }
    
    public void setPeriodarrangeStartTime(Integer periodarrangeStartTime) {
        this.periodarrangeStartTime = periodarrangeStartTime;
    }

    public Date getPeriodarrangeEndDate() {
        return this.periodarrangeEndDate;
    }
    
    public void setPeriodarrangeEndDate(Date periodarrangeEndDate) {
        this.periodarrangeEndDate = periodarrangeEndDate;
    }

    public Integer getPeriodarrangeEndTime() {
        return this.periodarrangeEndTime;
    }
    
    public void setPeriodarrangeEndTime(Integer periodarrangeEndTime) {
        this.periodarrangeEndTime = periodarrangeEndTime;
    }

    public Integer getPeriodarrangeAllClassNum() {
        return this.periodarrangeAllClassNum;
    }
    
    public void setPeriodarrangeAllClassNum(Integer periodarrangeAllClassNum) {
        this.periodarrangeAllClassNum = periodarrangeAllClassNum;
    }

    public Integer getPeriodarrangeSetUpUserId() {
        return this.periodarrangeSetUpUserId;
    }
    
    public void setPeriodarrangeSetUpUserId(Integer periodarrangeSetUpUserId) {
        this.periodarrangeSetUpUserId = periodarrangeSetUpUserId;
    }

    public Set<?> getClassarranges() {
        return this.classarranges;
    }
    
    public void setClassarranges(Set<?> classarranges) {
        this.classarranges = classarranges;
    }
   








}