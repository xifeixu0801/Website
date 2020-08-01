package com.regex.admin.dao.web;
import com.regex.admin.common.dto.web.NewsDTO;
import java.util.List;
import com.regex.admin.common.util.Assist;
import org.apache.ibatis.annotations.Param;
public interface INewsDao{
	/**
	 * 获得NewsDTO数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getNewsDTORowCount(Assist assist);
	/**
	 * 获得NewsDTO数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<NewsDTO> selectNewsDTO(Assist assist);
	/**
	 * 获得一个NewsDTO对象,以参数NewsDTO对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    NewsDTO selectNewsDTOByObj(NewsDTO obj);
	/**
	 * 通过NewsDTO的id获得NewsDTO对象
	 * @param id
	 * @return
	 */
    NewsDTO selectNewsDTOById(Long id);
	/**
	 * 插入NewsDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertNewsDTO(NewsDTO value);
	/**
	 * 插入NewsDTO中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyNewsDTO(NewsDTO value);
	/**
	 * 批量插入NewsDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertNewsDTOByBatch(List<NewsDTO> value);
	/**
	 * 通过NewsDTO的id删除NewsDTO
	 * @param id
	 * @return
	 */
    int deleteNewsDTOById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除NewsDTO
	 * @param assist
	 * @return
	 */
    int deleteNewsDTO(Assist assist);
	/**
	 * 通过NewsDTO的id更新NewsDTO中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateNewsDTOById(NewsDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新NewsDTO中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNewsDTO(@Param("enti") NewsDTO value, @Param("assist") Assist assist);
	/**
	 * 通过NewsDTO的id更新NewsDTO中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyNewsDTOById(NewsDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新NewsDTO中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyNewsDTO(@Param("enti") NewsDTO value, @Param("assist") Assist assist);
}