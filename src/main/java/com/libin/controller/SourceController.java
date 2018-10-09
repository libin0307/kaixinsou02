package com.libin.controller;

import com.libin.po.TSources;
import com.libin.test.JDBCkaixinsou;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by pc on 2018/9/27.
 */
@Controller
public class SourceController {
    JDBCkaixinsou jx = new JDBCkaixinsou();
    @RequestMapping("/insert.action")
    public ModelAndView insertSource(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("insertSource");
        return  mv;
    }
    @RequestMapping("/success.action")
    public String success(String sourceName,TSources sources){
        sources.setSourcename(sourceName);
        jx.insertSource(sources);
        return "success";

    }
    @RequestMapping("/query.action")
    public ModelAndView findSourceByName(String sourceName){
        List<TSources> list = jx.findSourcesByExample(sourceName);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("quneryList");
        return mv;
    }

}
