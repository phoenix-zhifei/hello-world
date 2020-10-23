package cn.test.manager.mapper;

import cn.test.manager.dto.UserDto;
import cn.test.manager.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzf
 * @since 2019-09-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
	/*@Select("select * from user where id = #{id}")
	User getUserById(@Param("id") Integer id);

	
	@Insert("INSERT INTO user (`id`, `username`, `sex`) VALUES (NULL, #{name}, #{sex});")
	int insertUser(@Param("name") String name, @Param("sex") String sex);*/
	
	@Select("select username from user where id = #{entity.id}")
	//List<UserDto> selectListzzf(@Param("id") Integer id);
	List<UserDto> selectListzzf(@Param("entity") User entity);
}
