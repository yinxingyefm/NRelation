package pdsu.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.dao.ViewDao;
import pdsu.domain.Node;
import pdsu.domain.View;
import pdsu.service.ViewService;
import java.util.*;


/**
 * @author ljk
 */

@Service
@Transactional
public class ViewServiceImpl implements ViewService {
    @Autowired
    private ViewDao viewDao;
    @Override
    public Map<Integer, List<View>> Infor(String num, Integer n,Date begin,Date end) {
        //存放查询人员信息
        Map<Integer,List<View>> map=new HashMap<Integer, List<View>>();
        //存放不同学工号
        List<String> disXGH=new ArrayList<String>();
        //存放所有的房间编号
        List<String> allFJBH=new ArrayList<String>();
        //之前的信息
        List<String> before=new ArrayList<String>();
        disXGH.add(num);
        List<String> list = firstFJBH(num,begin,end);
        //查询第一代所有的房间编号
        if (n==1){
            allFJBH.addAll(list);
            for (String s:list){
                List<String> allXGH = viewDao.allXGH(s,disXGH,begin,end);
                //根据所有不重复学工号查询信息
                List<View> views = allInfoByXGH(allXGH);
                map.put(1, views);
                //将查出来的学工号作为下一次排重的条件
                disXGH.addAll(allXGH);
            }
            return map;
        }else {
            if (list.size()>0){
                //房间编号
                   before.addAll(list);
                List<View> info;
                  for (int i=1;i<=n;i++)
                {
                    int flag=1;
                    //遍历房间编号
                   info= new ArrayList<View>();
                    for (String s:before) {
                        //查询当代的学工号,去掉上一代
                        List<String> allXGH = viewDao.allXGH(s,disXGH,begin,end);
                        System.out.println(allXGH+"pppp");
                        //根据所有不重复学工号查询信息
                        List<View> views = allInfoByXGH(allXGH);
                        if (views.size()>0){
//                            map.put(flag, views);
                            info.addAll(views);
                            //将查出来的学工号作为下一次排重的条件
                            disXGH.addAll(allXGH);
//
                        }
                    }
                    //本带信息
                    ArrayList<String> beforeid = new ArrayList<String>();
                    for (View  v:info) {
                        beforeid.add(v.getFJBH());
                    }
                    //上一代信息
                    ArrayList<String> beforD = new ArrayList<String>();
                    beforD.addAll(before);
                    before.addAll(beforeid);
                    before.removeAll(beforD);
                    map.put(i,info);
                    flag++;
                }
            }

        }
        return map;
    }


  //查询第一次接触的房间编号
    private List<String> firstFJBH(String XGH,Date begin,Date end){
        return   viewDao.allRoom(XGH,begin,end);
    }

    //通过每次查询的学工号集合来查询信息
    private List<View> allInfoByXGH(List<String> allXGH){
      List<View> views= new ArrayList<View>();
       if (allXGH.size()>0){
           for (String s:allXGH) {
               List<View> view = viewDao.allbByNum(s);
               views.addAll(view);
           }
       }
        return  views;
    }


    //查询最近信息
    @Override
    public List<Map<String, Object>>   all(String XGH, Date kssj, Date jssj){
        Map<String,Object> map0 = new HashMap<String,Object>();
        map0.put("xgh", XGH);
        map0.put("kssj", kssj);
        map0.put("jssj", jssj);
        List<Map<String, Object>>   list = viewDao.allByXGHByKJ(map0);
        if(list.size()==0){//无数据时，取离开始时间最近的一条数据(取最大)
            map0.put("kssj", null);
            map0.put("jssj", jssj);
            List<Map<String, Object>> list2 = viewDao.allByXGHByKJ(map0);
            if(list2.size()!=0){
                list.add(list2.get(list2.size()-1));
            }else{//无数据时，取离结束时间最近的一条数据(取最小)
                map0.put("kssj", kssj);
                map0.put("jssj", null);
                List<Map<String, Object>> list3 = viewDao.allByXGHByKJ(map0);
                if(list3.size()!=0){
                    list.add(list3.get(0));
                }
            }
        }
        return  list;
    }


    /***
     *     查询节点信息
     */
    @Override
    public Node allListInfor(String num, Integer n, Date begin, Date end) {
        //存放不同学工号
        List<String> disXGH=new ArrayList<String>();
        //存放所有的房间编号
        List<String> allFJBH=new ArrayList<String>();
        //之前的房间信息
        List<String> before=new ArrayList<String>();
        //节点
        Node node = new Node();
        disXGH.add(num);
        //查询第一代所有的房间编号
        List<String> list = firstFJBH(num,begin,end);
        List<View> views = viewDao.allByXGH(num);
        View view = views.get(0);
        //设置姓名
        node.setXM(view.getXM());
        //设置学号
        node.setXGH(view.getXGH());
        if (n==1){
            allFJBH.addAll(list);
            ArrayList<Node> chirld = new ArrayList<Node>();
            for (String s:list){
                List<View> byXGHInfo = viewDao.allByXGHInfo(s, disXGH, begin, end);
                byXGHInfo=repeatList(byXGHInfo);
                List<Node> nodes = nodeList(byXGHInfo);
                //根据所有不重复学工号查询信息
                List<String> allXGH = viewDao.allXGH(s,disXGH,begin,end);
                //将查出来的学工号作为下一次排重的条件
                disXGH.addAll(allXGH);
                chirld.addAll(nodes);
            }
            node.setChirlden(chirld);
           return  node;
        }else {
            if (list.size()>0){
                //房间编号
                before.addAll(list);
                List<View> byXGHInfo = viewDao.allByXGHInfoB(before, disXGH, begin, end);
                byXGHInfo=repeatList(byXGHInfo);
                List<Node> nodes = nodeList(byXGHInfo);
                node.setChirlden(nodes);
                List<Node> beforNode=new ArrayList<Node>();
                beforNode.addAll(nodes);
                List<Node> now = null;
                for (int i=1;i<n;i++){
                    now =   new ArrayList<Node>();
                    for (Node nodep:beforNode) {
                        List<View> byInfo = viewDao.allByXGHInfoB(before, disXGH, begin, end);

                        List<String> numList = num(byInfo);
                        disXGH.addAll(numList);
                        before.addAll(FJBH(byInfo));
                        if (byInfo.size()>0){
                            List<Node> nod = nodeList(byInfo);
                            nodep.setChirlden(nod);
                            System.out.println(nod);
                            now.addAll(nod);
                        }

                    }
                    ArrayList<Node> nodesBefore = new ArrayList<Node>();
                    nodesBefore.addAll(beforNode);
                    if (now.size()>0){
                        beforNode.addAll(now);
                        beforNode.removeAll(nodesBefore);
                    }

                }
            }
            }
        return node;
    }

    private List<String> num(List<View> info){
        ArrayList<String> list = new ArrayList<String>();
        for (View v:info) {
            list.add(v.getXGH());
        }
        return  list;
    }


    private List<String> FJBH(List<View> info){
        ArrayList<String> list = new ArrayList<String>();
        for (View v:info) {
            list.add(v.getFJBH());
        }
        return  list;
    }


    //节点转换
    private List<Node> nodeList(List<View> viewList){
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (View v:viewList) {
            Node node = new Node();
            node.setXM(v.getXM());
            node.setXGH(v.getXGH());
            nodes.add(node);
        }
        return  nodes;
    }

     //去重
    public List<View> repeatList(List<View> list)
    {
        System.out.println("去重前："+list);
        Set<View> userSet = new HashSet<View>(list);
        list.clear();
        list.addAll(userSet);
        System.out.println("去重后："+list);
        return list;
    }

}
