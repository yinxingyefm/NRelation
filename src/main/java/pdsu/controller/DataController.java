package pdsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pdsu.domain.Node;
import pdsu.domain.RequestData;
import pdsu.domain.View;
import pdsu.service.ViewService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @auther yinxingye
 * @date 2020/5/18 7:49
 */
@RestController
@RequestMapping("/")
public class DataController {
    @Autowired
    private ViewService service;

    @RequestMapping(method=RequestMethod.POST,value="findRelation")
    public  ResponseData ShowNMessage(@RequestBody RequestData data) {
        ResponseData responseData = ResponseData.ok();
        Map<Integer, List<View>> infor = service.Infor(data.getNum(), data.getN(), data.getStartTime(),data.getEndTime());
        if(infor.size()>0){
            responseData.setObject(infor);
        }
        return responseData;
    }
    @RequestMapping(method=RequestMethod.POST,value="findTree")
    public  ResponseData findTree(@RequestBody RequestData data) {
        ResponseData responseData = ResponseData.ok();
        Node node = service.allListInfor(data.getNum(), data.getN(), data.getStartTime(), data.getEndTime());
        if(node!=null){
            responseData.setObject(node);
        }
        return responseData;
    }


}
