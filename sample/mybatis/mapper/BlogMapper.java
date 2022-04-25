package mybatis.mapper;

import org.apache.ibatis.annotations.Select;

import domain.Blog;

public interface BlogMapper{
	
	@Select("SELECT * FROM blog WHERE id = #{id}")
	public Blog selectBlog(int id);

}
