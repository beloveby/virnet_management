package virnet.management.entity;



/**
 * ClassarrangeCase entity. @author MyEclipse Persistence Tools
 */

public class ClassarrangeCase  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 5291280266403677829L;
	private Integer classarrangeCaseId;
     private Classarrange classarrange;
     private Exp exp;
     private Integer classarrangeCaseUnitedOrder;
     private Integer classarrangeCaseMinOrderNum;
     private Integer classarrangeCaseMaxOrderNum;
     private Integer classarrangeCaseMinStartNum;
     private Integer classarrangeCaseMaxStartNum;


    // Constructors

    /** default constructor */
    public ClassarrangeCase() {
    }

	/** minimal constructor */
    public ClassarrangeCase(Integer classarrangeCaseId, Classarrange classarrange, Exp exp) {
        this.classarrangeCaseId = classarrangeCaseId;
        this.classarrange = classarrange;
        this.exp = exp;
    }
    
    /** full constructor */
    public ClassarrangeCase(Integer classarrangeCaseId, Classarrange classarrange, Exp exp, Integer classarrangeCaseUnitedOrder, Integer classarrangeCaseMinOrderNum, Integer classarrangeCaseMaxOrderNum, Integer classarrangeCaseMinStartNum, Integer classarrangeCaseMaxStartNum) {
        this.classarrangeCaseId = classarrangeCaseId;
        this.classarrange = classarrange;
        this.exp = exp;
        this.classarrangeCaseUnitedOrder = classarrangeCaseUnitedOrder;
        this.classarrangeCaseMinOrderNum = classarrangeCaseMinOrderNum;
        this.classarrangeCaseMaxOrderNum = classarrangeCaseMaxOrderNum;
        this.classarrangeCaseMinStartNum = classarrangeCaseMinStartNum;
        this.classarrangeCaseMaxStartNum = classarrangeCaseMaxStartNum;
    }

   
    // Property accessors

    public Integer getClassarrangeCaseId() {
        return this.classarrangeCaseId;
    }
    
    public void setClassarrangeCaseId(Integer classarrangeCaseId) {
        this.classarrangeCaseId = classarrangeCaseId;
    }

    public Classarrange getClassarrange() {
        return this.classarrange;
    }
    
    public void setClassarrange(Classarrange classarrange) {
        this.classarrange = classarrange;
    }

    public Exp getExp() {
        return this.exp;
    }
    
    public void setExp(Exp exp) {
        this.exp = exp;
    }

    public Integer getClassarrangeCaseUnitedOrder() {
        return this.classarrangeCaseUnitedOrder;
    }
    
    public void setClassarrangeCaseUnitedOrder(Integer classarrangeCaseUnitedOrder) {
        this.classarrangeCaseUnitedOrder = classarrangeCaseUnitedOrder;
    }

    public Integer getClassarrangeCaseMinOrderNum() {
        return this.classarrangeCaseMinOrderNum;
    }
    
    public void setClassarrangeCaseMinOrderNum(Integer classarrangeCaseMinOrderNum) {
        this.classarrangeCaseMinOrderNum = classarrangeCaseMinOrderNum;
    }

    public Integer getClassarrangeCaseMaxOrderNum() {
        return this.classarrangeCaseMaxOrderNum;
    }
    
    public void setClassarrangeCaseMaxOrderNum(Integer classarrangeCaseMaxOrderNum) {
        this.classarrangeCaseMaxOrderNum = classarrangeCaseMaxOrderNum;
    }

    public Integer getClassarrangeCaseMinStartNum() {
        return this.classarrangeCaseMinStartNum;
    }
    
    public void setClassarrangeCaseMinStartNum(Integer classarrangeCaseMinStartNum) {
        this.classarrangeCaseMinStartNum = classarrangeCaseMinStartNum;
    }

    public Integer getClassarrangeCaseMaxStartNum() {
        return this.classarrangeCaseMaxStartNum;
    }
    
    public void setClassarrangeCaseMaxStartNum(Integer classarrangeCaseMaxStartNum) {
        this.classarrangeCaseMaxStartNum = classarrangeCaseMaxStartNum;
    }
   








}