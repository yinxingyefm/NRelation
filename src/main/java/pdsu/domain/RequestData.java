package pdsu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @auther yinxingye
 * @date 2020/5/18 10:01
 */
public class RequestData {


    private String num;

    private Integer n;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public Integer getN() {
        return n;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setN(Integer n) {
        this.n = n;
    }


    @Override
    public String toString() {
        return "RequestData{" +
                "num='" + num + '\'' +
                ", n=" + n +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
