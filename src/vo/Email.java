package vo;
// Generated 17/02/2014 13:51:28 by Hibernate Tools 3.6.0



/**
 * Email generated by hbm2java
 */
public class Email  implements java.io.Serializable {


     private Integer codemail;
     private Listaemail listaemail;
     private String email;
     private String status;
     private int coddono;

    /**
     *
     */
    public Email() {
    }

    /**
     *
     * @param listaemail
     * @param email
     * @param coddono
     */
    public Email(Listaemail listaemail, String email, int coddono) {
        this.listaemail = listaemail;
        this.email = email;
        this.coddono = coddono;
    }

    /**
     *
     * @param listaemail
     * @param email
     * @param status
     * @param coddono
     */
    public Email(Listaemail listaemail, String email, String status, int coddono) {
       this.listaemail = listaemail;
       this.email = email;
       this.status = status;
       this.coddono = coddono;
    }
   
    /**
     *
     * @return
     */
    public Integer getCodemail() {
        return this.codemail;
    }
    
    /**
     *
     * @param codemail
     */
    public void setCodemail(Integer codemail) {
        this.codemail = codemail;
    }

    /**
     *
     * @return
     */
    public Listaemail getListaemail() {
        return this.listaemail;
    }
    
    /**
     *
     * @param listaemail
     */
    public void setListaemail(Listaemail listaemail) {
        this.listaemail = listaemail;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return this.status;
    }
    
    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public int getCoddono() {
        return this.coddono;
    }
    
    /**
     *
     * @param coddono
     */
    public void setCoddono(int coddono) {
        this.coddono = coddono;
    }




}

