package com.zguiz.view;

import com.zguiz.bean.Book;
import com.zguiz.bean.Category;
import com.zguiz.bean.Pager;
import com.zguiz.service.IBookService;
import com.zguiz.service.ICategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;

    private Logger logger=Logger.getRootLogger();
    /**
     * 查找所有书籍
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String listBook(Model model){
        //Model是Spring MVC封装的数据模型，用于在mvc各组件中传递数据，类似于HttpServlet对象
        List<Book> list=bookService.findBook(new Book());
        model.addAttribute("books",list);
        return "booklist";
    }

    /**
     * 跳转到添加书籍页面
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView toAddBook(){
        List<Category> categories=categoryService.findAllCategory();
        ModelAndView view=new ModelAndView("addbook");
        view.getModel().put("categories",categories);
        return view;
    }

    //BindingResult必须加载@Validated后面
    @RequestMapping("/doadd")
    public String doAddBook(HttpServletRequest request,Model model, @Validated Book book, BindingResult result, MultipartFile bookIcon) throws IOException {
        //客户端提交到spring mvc后，会先进行数据封装和转换、校验，完成后再控制器内进行处理
        //可以使用校验框架进行数据的集中校验，并获得校验结果
        if(result.hasErrors()){
            List<ObjectError> objectErrors=result.getAllErrors();
            model.addAttribute("errors",objectErrors);
            for(ObjectError oe:objectErrors){
                logger.debug(oe.getObjectName()+":"+oe.getDefaultMessage());
            }
            return "forward:/book/add";
        }
        if(!bookIcon.isEmpty()){
            String path=request.getServletContext().getRealPath("/uploads/");
            String filename=bookIcon.getOriginalFilename();
            String fileExt=filename.substring(filename.lastIndexOf("."));
            String uuid= UUID.randomUUID().toString();
            String newFile=uuid+fileExt;
            File filepath=new File(path,newFile);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdir();
            }
            bookIcon.transferTo(new File(path+File.separator+newFile));
            book.setBookImage("uploads/"+newFile);
        }
        if(bookService.addBook(book)){
            return "redirect:/book/listbypager.action";
        }
        else{
            return "forward:/book/add.action";
        }
    }

    @RequestMapping("/del")
    public String delBook(Model model,String isbn){
        boolean res=bookService.deleteBook(isbn);
        if(res){
            model.addAttribute("result",res);
            return "result";
        }
        return "forward:/book/listbypager.action";
    }

    @RequestMapping("/delbyajax")
    @ResponseBody
    public String delByAjax(String isbn){
        boolean res=bookService.deleteBook(isbn);
        return "{result:"+res+"}";
    }

    @RequestMapping(value="/ajaxpager",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String lisBookFromAjax(Integer page){
        if(page==null){
            page=1;
        }
        Pager pager=new Pager();
        pager.setTotal(bookService.countForPager(pager));
        pager.setCurrentPage(page);
        List<Book> books=bookService.findBookByPager(pager);
        String res = Book.toJson(books);
        return res;
    }

    @RequestMapping("/update")
    public ModelAndView toUpdateBook(String isbn){
        Book book=new Book();
        book.setIsbn(isbn);
        List<Book> books=bookService.findBook(book);
        List<Category> categories=categoryService.findAllCategory();
        ModelAndView view=new ModelAndView("updatebook");
        view.getModel().put("book",books.get(0));
        view.getModel().put("categories",categories);
        return view;
    }

    @RequestMapping("/doupdate")
    public String doUpdate(Book book){
        if(bookService.updateBook(book)){
            return "forward:/book/listbypager.action";
        }
        return "forward:/book/update.action?isbn="+book.getIsbn();
    }

    @RequestMapping("/listbypager")
    public ModelAndView listBookByPage(Pager pager){
        if (pager.getBook() != null) {
            System.out.println(pager.getBook().toString());
        }
        ModelAndView view=new ModelAndView("booklistbypager");
        pager.setTotal(bookService.countForPager(pager));
        List<Book> books=bookService.findBookByPager(pager);
        List<Category> categories=categoryService.findAllCategory();
        view.getModel().put("books",books);
        view.getModel().put("categories",categories);
        view.getModel().put("pager",pager);
        return view;
    }

    @RequestMapping("findbyisbn")
    @ResponseBody
    public String findByIsbn(String isbn){
        Book book=new Book();
        book.setIsbn(isbn);
        List<Book> books=bookService.findBook(book);
        if(books.size()>0){
            return "{result:false}";
        }
        else{
            return "{result:true}";
        }
    }
}
