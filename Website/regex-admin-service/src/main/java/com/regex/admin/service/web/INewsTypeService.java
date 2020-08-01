package com.regex.admin.service.web;
import java.util.List;
import com.regex.admin.common.dto.web.NewsTypeDTO;
import com.regex.admin.common.util.Assist;
public interface INewsTypeService{
	/**
	 * 获得NewsTypeDTO数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getNewsTypeDTORowCount(Assist assist);
	/**
	 * 获得NewsTypeDTO数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<NewsTypeDTO> selectNewsTypeDTO(Assist assist);
	/**
	 * 获得一个NewsTypeDTO对象,以参数NewsTypeDTO对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    NewsTypeDTO selectNewsTypeDTOByObj(NewsTypeDTO obj);
	/**
	 * 通过NewsTypeDTO的id获得NewsTypeDTO对象
	 * @param id
	 * @return
	 */
    NewsTypeDTO selectNewsTypeDTOById(Long id);
	/**
	 * 插入NewsTypeDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertNewsTypeDTO(NewsTypeDTO value);
	/**
	 * 插入NewsTypeDTO中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyNewsTypeDTO(NewsTypeDTO value);
	/**
	 * 批量插入NewsTypeDTO到数据库
	 * @param value
	 * @return
	 */
    int insertNewsTypeDTOByBatch(List<NewsTypeDTO> value);
	/**
	 * 通过NewsTypeDTO的id删除NewsTypeDTO
	 * @param id
	 * @return
	 */
    int deleteNewsTypeDTOById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除NewsTypeDTO
	 * @param assist
	 * @return
	 */
    int deleteNewsTypeDTO(Assist assist);
	/**
	 * 通过NewsTypeDTO的id更新NewsTypeDTO中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateNewsTypeDTOById(NewsTypeDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新NewsTypeDTO中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNewsTypeDTO(NewsTypeDTO value,  Assist assist);
	/**
	 * 通过NewsTypeDTO的id更新NewsTypeDTO中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyNewsTypeDTOById(NewsTypeDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新NewsTypeDTO中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyNewsTypeDTO(NewsTypeDTO value, Assist assist);
}