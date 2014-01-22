package spms.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControl {

	@RequestMapping("/main")
  public String execute() throws Exception {
		//resultMap.put("pageTitle", "SPMS 메인");
		return "main";
  }
}










