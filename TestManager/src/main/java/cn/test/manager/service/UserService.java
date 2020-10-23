package cn.test.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.IService;

import cn.test.manager.dto.UserDto;
import cn.test.manager.entity.User;


public interface UserService extends IService<User> {
	void updateById(String username, Integer id);
	public Object getUserById(Integer id);
	
	public Object selectPage(Integer pagenum, Integer pageSize);
	
	public List<UserDto> selectList(int id);
	
}
