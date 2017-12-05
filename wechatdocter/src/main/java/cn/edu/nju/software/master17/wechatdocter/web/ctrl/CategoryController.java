package cn.edu.nju.software.master17.wechatdocter.web.ctrl;

import cn.edu.nju.software.master17.wechatdocter.models.Category;
import cn.edu.nju.software.master17.wechatdocter.service.CategoryService;
import cn.edu.nju.software.master17.wechatdocter.web.data.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
    public CategoryVO getCategories(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @RequestMapping(value = "/api/category", method = RequestMethod.POST)
    public CategoryVO addCategory(@RequestParam(name = "pid") Long pid,
                                  @RequestParam(name = "nodeName") String nodeName) {
        return categoryService.addCategory(pid,nodeName);
    }

    @RequestMapping(value = "/api/category", method = RequestMethod.PUT)
    public CategoryVO updateCategory(@RequestParam(name = "id") Long id,
                                     @RequestParam(name = "newName") String newName) {
        return categoryService.updateCategory(id,newName);
    }

    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.DELETE)
    public CategoryVO deleteCategory(@PathVariable("id") Long id){
        return categoryService.deleteCategory(id);
    }

}
