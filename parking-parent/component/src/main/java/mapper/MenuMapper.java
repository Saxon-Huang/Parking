package mapper;

import entity.Menu;
import entity.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer mId);

    int insert(Menu row);

    int insertSelective(Menu row);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer mId);

    int updateByExampleSelective(@Param("row") Menu row, @Param("example") MenuExample example);

    int updateByExample(@Param("row") Menu row, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu row);

    int updateByPrimaryKey(Menu row);
}