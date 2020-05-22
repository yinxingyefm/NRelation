package pdsu.service;


import pdsu.domain.Node;
import pdsu.domain.View;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ljk
 */
public interface ViewService {

  //展示信息
    public Map<Integer, List<View>> Infor(String num, Integer n, Date begin, Date end);

  //最近去的地方
   public List<Map<String, Object>>   all(String XGH,Date kssj,Date jssj);

   //查询孩子节点
   public  Node allListInfor(String num, Integer n, Date begin, Date end);





}
