package com.regex.admin.dao.web;
import com.regex.admin.common.dto.web.MessageDTO;
import java.util.List;
import com.regex.admin.common.util.Assist;
import org.apache.ibatis.annotations.Param;
public interface IMessageDao{
	/**
	 * 获得MessageDTO数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getMessageDTORowCount(Assist assist);
	/**
	 * 获得MessageDTO数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<MessageDTO> selectMessageDTO(Assist assist);
	/**
	 * 获得一个MessageDTO对象,以参数MessageDTO对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    MessageDTO selectMessageDTOByObj(MessageDTO obj);
	/**
	 * 通过MessageDTO的id获得MessageDTO对象
	 * @param id
	 * @return
	 */
    MessageDTO selectMessageDTOById(Long id);
	/**
	 * 插入MessageDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertMessageDTO(MessageDTO value);
	/**
	 * 插入MessageDTO中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyMessageDTO(MessageDTO value);
	/**
	 * 批量插入MessageDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertMessageDTOByBatch(List<MessageDTO> value);
	/**
	 * 通过MessageDTO的id删除MessageDTO
	 * @param id
	 * @return
	 */
    int deleteMessageDTOById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除MessageDTO
	 * @param assist
	 * @return
	 */
    int deleteMessageDTO(Assist assist);
	/**
	 * 通过MessageDTO的id更新MessageDTO中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateMessageDTOById(MessageDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新MessageDTO中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateMessageDTO(@Param("enti") MessageDTO value, @Param("assist") Assist assist);
	/**
	 * 通过MessageDTO的id更新MessageDTO中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyMessageDTOById(MessageDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新MessageDTO中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyMessageDTO(@Param("enti") MessageDTO value, @Param("assist") Assist assist);
}