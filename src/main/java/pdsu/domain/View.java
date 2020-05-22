package pdsu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ljk
 */
public class View {

    //学工号
    private String XGH;

    //姓名
    private String XM;
    //进入时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date JRSJ;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    //出去时间
    private  Date CQSJ;
    //职工类型
    private  String  USERTYPE;
    //楼宇编号
    private Integer LYBH;
   //楼宇名称
    private  String LYMC;
    //校区编号
    private  Integer XQBH;
    //楼层名称
    private  String LCMC;
    //房间名称
    private  String FJMC;

    //X坐标
    private String LYZBX;

    private List<View> chirld=new ArrayList<View>();

    public List<View> getChirld() {
        return chirld;
    }

    public void setChirld(List<View> chirld) {
        this.chirld = chirld;
    }

    //Y坐标
    private String LYZBY;

    public String getLYZBY() {

        return LYZBY;
    }

    public void setLYZBY(String LYZBY) {
        this.LYZBY = LYZBY;
    }

    public String getLYZBX() {
        return LYZBX;
    }

    public void setLYZBX(String LYZBX) {
        this.LYZBX = LYZBX;
    }

    private String FJBH;

    public String getFJBH() {
        return FJBH;
    }

    public void setFJBH(String FJBH) {
        this.FJBH = FJBH;
    }

    public String getXGH() {
        return XGH;
    }

    public void setXGH(String XGH) {
        this.XGH = XGH;
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }

    public Date getJRSJ() {
        return JRSJ;
    }

    public void setJRSJ(Date JRSJ) {
        this.JRSJ = JRSJ;
    }

    public Date getCQSJ() {
        return CQSJ;
    }

    public void setCQSJ(Date CQSJ) {
        this.CQSJ = CQSJ;
    }

    public String getUSERTYPE() {
        return USERTYPE;
    }

    public void setUSERTYPE(String USERTYPE) {
        this.USERTYPE = USERTYPE;
    }

    public Integer getLYBH() {
        return LYBH;
    }

    public void setLYBH(Integer LYBH) {
        this.LYBH = LYBH;
    }

    public String getLYMC() {
        return LYMC;
    }

    public void setLYMC(String LYMC) {
        this.LYMC = LYMC;
    }

    public Integer getXQBH() {
        return XQBH;
    }

    public void setXQBH(Integer XQBH) {
        this.XQBH = XQBH;
    }

    public String getLCMC() {
        return LCMC;
    }

    public void setLCMC(String LCMC) {
        this.LCMC = LCMC;
    }

    public String getFJMC() {
        return FJMC;
    }

    public void setFJMC(String FJMC) {
        this.FJMC = FJMC;
    }

    @Override
    public String toString() {
        return "View{" +
                "XGH='" + XGH + '\'' +
                ", XM='" + XM + '\'' +
                ", JRSJ=" + JRSJ +
                ", CQSJ=" + CQSJ +
                ", USERTYPE='" + USERTYPE + '\'' +
                ", LYBH=" + LYBH +
                ", LYMC='" + LYMC + '\'' +
                ", XQBH=" + XQBH +
                ", LCMC='" + LCMC + '\'' +
                ", FJMC='" + FJMC + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        View u = (View) obj;
        return XGH.equals(u.XGH);
    }

    @Override
    public int hashCode() {
        String in = XGH;
        return in.hashCode();
    }
}



