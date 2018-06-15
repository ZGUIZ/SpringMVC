package com.zguiz.test;

//import com.zguiz.view.BookController;
//import org.apache.log4j.Logger;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//
//public class TestBookController {
//    private ApplicationContext context;
//    private BookController bookController;
//    private Logger logger=Logger.getRootLogger();
//    @Before
//    public void init(){
//        String configLocation="applicationContext.xml";
//        String configLocation2="springmvc-servlet.xml";
//        context=new ClassPathXmlApplicationContext(configLocation,configLocation2);
//        bookController=context.getBean(BookController.class);
//    }
//
//    @Test
//    public void testBookList(){
//        String result=bookController.listBook(null);
//        logger.info(result);
//    }
//}
