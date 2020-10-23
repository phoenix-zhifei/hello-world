package cn.test.manager.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.test.manager.dto.UserDto;
import cn.test.manager.entity.User;
import cn.test.manager.mapper.UserMapper;
import cn.test.manager.service.UserService;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public void updateById(String username, Integer id) {
		User selectById = userMapper.selectById(id);
		selectById.setUsername(username);
		userMapper.updateById(selectById);
	}

	
	public Object getUserById(Integer id) {
		return userMapper.selectById(id);
		//return userMapper.getUserById(id);
	}
	
	public Object selectPage(Integer pagenum, Integer pageSize)	{
		Wrapper<User> wrapper = new EntityWrapper<>();
		RowBounds rowBounds = new RowBounds((pagenum - 1) * pageSize, pageSize);
		return userMapper.selectPage(rowBounds, wrapper);
		
	}


	@Override
	public List<UserDto> selectList(int id) {
		// TODO Auto-generated method stub
		User entity = new User();
		entity.setId(id);
		
		return userMapper.selectListzzf(entity);
	}


	
}
