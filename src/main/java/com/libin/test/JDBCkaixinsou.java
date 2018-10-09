package com.libin.test;

import com.libin.po.TSources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.SourceFilteringListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javafx.scene.input.KeyCode.M;

/**
 * Created by pc on 2018/9/26.
 */
public class JDBCkaixinsou {
    /**
     * 添加资源
     * @param sources
     */
    public void insertSource(TSources sources) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        jt.update("INSERT INTO t_sources(sourceName,links,size,details) VALUES (?,?,?,?)",sources.getSourcename(),sources.getLinks(),sources.getSize(),sources.getDetails());


        //List<TSources> list = jt.query("SELECT*FROM t_sources WHERE id>?",new BeanPropertyRowMapper<TSources>(TSources.class),0);
        //for (TSources item:list){
        //    System.out.println(item.getId()+"+"+item.getSourcename()+"+"+item.getLinks()+"+"+item.getSize()+"+"+item.getSize()+"+"+item.getDetails());
        //}
    }



    /**
     * 删除资源
     * @param id
     */
    public void deleteSourceByid(Integer id){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        jt.update("DELETE FROM t_sources WHERE id=?",id);
    }

    /**
     * 更新资源
     * @param id
     * @param sources
     */
    public void updateSourceByid(Integer id,TSources sources){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        jt.update("UPDATE t_sources SET sourceName=?,links=?,size=?,details=? WHERE id=?",sources.getSourcename(),sources.getLinks(),sources.getSize(),sources.getDetails(),id);

    }

    /**
     * 查询资源
     * @param sourceName
     * @return
     */
    public List<TSources> findSourcesByExample(String sourceName){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        String sql = "%"+sourceName+"%";
        List<TSources> list = jt.query("SELECT*FROM t_sources WHERE sourceName LIKE ?", new BeanPropertyRowMapper<TSources>(TSources.class), sql);
        return list;
    }

    public static void main(String[] args) {
        JDBCkaixinsou jx = new JDBCkaixinsou();

        List<TSources> list = jx.findSourcesByExample("特");
        for(TSources tSources:list){
            System.out.println(tSources.getSourcename()+tSources.getLinks());
        }
    }
}
