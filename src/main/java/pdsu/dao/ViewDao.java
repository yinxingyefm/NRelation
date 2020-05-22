package pdsu.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pdsu.domain.Node;
import pdsu.domain.View;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ljk
 */
@Repository
public interface ViewDao {

  //查询所有信息
    List<View> all();

    //利用学工号查询所有去过的房间编号
    List<String> allRoom(@Param("XGH") String XGH, @Param("begin") Date begin,@Param("end")Date end);

    //根据房间编号查找人员学工号
    List<String> allXGH(@Param("FJBH") String  FJBH,@Param("list") List<String> list,@Param("begin") Date begin,@Param("end") Date end);

  //通过学工号查询信息
  List<View> allbByNum(String XGH);

    //查询所有不重复的房间号
  List<String> allDisRoom(@Param("XGH") String XGH,@Param("list") List<String> list);

  List<View> allByXGH(@Param("XGH") String XGH);

  //查询最近的的地区信息
  List<Map<String, Object>> allByXGHByKJ(Map<String,Object> map);

  /**
   *
   * @param FJBH
   * @param list
   * @param begin
   * @param end
   * @return
   */
  List<View> allByXGHInfo(@Param("FJBH") String  FJBH, @Param("list") List<String> list, @Param("begin") Date begin, @Param("end") Date end);



  Node allNode(@Param("XGH") String  XGH,  @Param("begin") Date begin, @Param("end") Date end);


  List<View> allByXGHInfoB(@Param("before") List<String> before, @Param("list") List<String> list, @Param("begin") Date begin, @Param("end") Date end);
}
