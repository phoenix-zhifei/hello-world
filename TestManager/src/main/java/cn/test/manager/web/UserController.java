package cn.test.manager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.test.manager.dto.UserDto;
import cn.test.manager.entity.User;
import cn.test.manager.service.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserController {	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello i am jd";
		
	}

	@RequestMapping("/excep")
	public String excep(){
		int a = 2 / 0;
		return "exception";		
	}
	
	@RequestMapping("/getuser/{id}")
	public Object getUser(@PathVariable(name = "id") Integer id) {
		return userService.selectById(id);
	}
	 
	@RequestMapping("selectpage")
	public Object selectPage(Integer pagenum, Integer pageSize) {
		return userService.selectPage(pagenum, pageSize);
	}

	@RequestMapping("selectList/{id}")
	public List<UserDto> selectList(@PathVariable(name = "id") Integer id) {
		return userService.selectList(id);
	}
	
	@RequestMapping("selectListTest/{user}")
	public List<UserDto> selectListTest(@PathVariable(name = "user") User user) {
		return userService.selectList(user.getId());
	}

}
