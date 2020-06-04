package com.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebListener()
public class OnlineCounterListener implements HttpSessionListener {
    //number of online
    public static int activeSessions = 0;

    /* Session创建事件 */
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("newSession.id=" + se.getSession().getId() + "-->The number of online is " + Integer.toString(activeSessions));
        HttpSession session = se.getSession();
        // 获取 session 创建时间
        Date createTime = new Date(session.getCreationTime());
        //设置日期输出的格式
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("createtime=" + df.format(createTime));
        System.out.println("-------------------------------");

    }

    /* Session失效事件 */
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("outSession.id=" + se.getSession().getId() + "-->The number of online is " + Integer.toString(activeSessions));
        HttpSession session = se.getSession();
        // 获取该网页的最后一次访问时间
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        //设置日期输出的格式
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("The lastAccessTime " + df.format(lastAccessTime));
        System.out.println("-------------------------------");
    }
}
