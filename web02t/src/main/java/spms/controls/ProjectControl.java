package spms.controls;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spms.dao.ProjectDao;
import spms.propertyeditors.CustomSqlDateEditor;
import spms.vo.Project;

@Controller
@RequestMapping("/project")
public class ProjectControl {
	@Autowired(required=false)
	ProjectDao projectDao;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String form() {
		return "project/addForm";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(
			Project project, 
			Model model) throws Exception {
		int count = projectDao.insert(project);
		if (count > 0) {
			model.addAttribute("message", "등록 성공입니다!");
		} else {
			model.addAttribute("message", "등록 실패입니다!");
		}
		
		return "project/add";
	}
	
	@RequestMapping("/delete")
	public String delete(int no, Model model) throws Exception {
		projectDao.delete(no);
		return "redirect:list.do";
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("projects", projectDao.selectList());
		return "project/list";
	}
	
	@RequestMapping("/read")
	public String read(int no, Model model) throws Exception {
		Project project = projectDao.selectOne(no);
		model.addAttribute("project", project);
		return "project/updateForm";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
  public String update(Project project, Model model) throws Exception {
		int count = projectDao.update(project);
		if (count > 0) {
			model.addAttribute("message", "변경 성공입니다!");
		} else {
			model.addAttribute("message", "해당 번호의 회원 정보를 찾을 수 없습니다!");
		}
		return "project/update";
  }
	
	@InitBinder
  public void initBinder(HttpServletRequest request,
      ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
		binder.registerCustomEditor(java.util.Date.class, 
    		new CustomDateEditor(dateFormat, false));
		
    binder.registerCustomEditor(java.sql.Date.class, 
    		new CustomSqlDateEditor());
  }
	

}
