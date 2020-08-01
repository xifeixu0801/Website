package com.regex.admin.service.web;
import java.util.List;
import com.regex.admin.common.dto.web.WebInfoDTO;
import com.regex.admin.common.util.Assist;
public interface IWebInfoService{
	/**
	 * 获得WebInfoDTO数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getWebInfoDTORowCount(Assist assist);
	/**
	 * 获得WebInfoDTO数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<WebInfoDTO> selectWebInfoDTO(Assist assist);
	/**
	 * 获得一个WebInfoDTO对象,以参数WebInfoDTO对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    WebInfoDTO selectWebInfoDTOByObj(WebInfoDTO obj);
	/**
	 * 通过WebInfoDTO的id获得WebInfoDTO对象
	 * @param id
	 * @return
	 */
    WebInfoDTO selectWebInfoDTOById(Long id);
	/**
	 * 插入WebInfoDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertWebInfoDTO(WebInfoDTO value);
	/**
	 * 插入WebInfoDTO中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyWebInfoDTO(WebInfoDTO value);
	/**
	 * 批量插入WebInfoDTO到数据库
	 * @param value
	 * @return
	 */
    int insertWebInfoDTOByBatch(List<WebInfoDTO> value);
	/**
	 * 通过WebInfoDTO的id删除WebInfoDTO
	 * @param id
	 * @return
	 */
    int deleteWebInfoDTOById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除WebInfoDTO
	 * @param assist
	 * @return
	 */
    int deleteWebInfoDTO(Assist assist);
	/**
	 * 通过WebInfoDTO的id更新WebInfoDTO中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateWebInfoDTOById(WebInfoDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新WebInfoDTO中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateWebInfoDTO(WebInfoDTO value,  Assist assist);
	/**
	 * 通过WebInfoDTO的id更新WebInfoDTO中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyWebInfoDTOById(WebInfoDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新WebInfoDTO中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyWebInfoDTO(WebInfoDTO value, Assist assist);
}