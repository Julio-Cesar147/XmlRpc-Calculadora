package Server;

import java.util.Date;

public class BeanCalcu {
    private long id;
    private String type;
    private double fnum;
    private double snum;
    private double result;
    private Date created;

    public BeanCalcu() {
    }

    public BeanCalcu(long id, String type, double fnum, double snum, double result, Date created) {
        this.id = id;
        this.type = type;
        this.fnum = fnum;
        this.snum = snum;
        this.result = result;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFnum() {
        return fnum;
    }

    public void setFnum(double fnum) {
        this.fnum = fnum;
    }

    public double getSnum() {
        return snum;
    }

    public void setSnum(double snum) {
        this.snum = snum;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
