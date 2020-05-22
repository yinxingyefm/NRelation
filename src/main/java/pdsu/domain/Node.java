package pdsu.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljk
 */
public class Node {

    //名字
    private  String XM;

    //值
    private  String XGH;

    //孩子节点
    private List<Node> chirlden=new ArrayList<Node>();

    public String getXGH() {
        return XGH;
    }

    @Override
    public String toString() {
        return "Node{" +
                "XM='" + XM + '\'' +
                ", XGH='" + XGH + '\'' +
                ", chirlden=" + chirlden +
                '}';
    }

    public void setXGH(String XGH) {
        this.XGH = XGH;
    }

    public List<Node> getChirlden() {
        return chirlden;
    }

    public void setChirlden(List<Node> chirlden) {
        this.chirlden = chirlden;
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }
}
