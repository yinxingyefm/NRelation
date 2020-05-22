package TEST;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pdsu.domain.Node;
import pdsu.domain.View;
import pdsu.service.ViewService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ljk
 */
public class ViewTest {

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ViewService bean = classPathXmlApplicationContext.getBean(ViewService.class);
        String s="2020-05-15";
        String s1="2020-05-20";
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper objectMapper = new ObjectMapper();
        Date begin = f.parse(s);
        Date end= f.parse(s1);
        Node node = bean.allListInfor("5902", 6, begin, end);
        String valueAsString = objectMapper.writeValueAsString(node);
        System.out.println(valueAsString);





    }



}
