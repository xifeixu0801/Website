package com.regex.admin.service.web;
import java.util.List;
import com.regex.admin.common.dto.web.AboutUsDTO;
import com.regex.admin.common.util.Assist;
public interface IAboutUsService{
	/**
	 * 获得AboutUsDTO数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAboutUsDTORowCount(Assist assist);
	/**
	 * 获得AboutUsDTO数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AboutUsDTO> selectAboutUsDTO(Assist assist);
	/**
	 * 获得一个AboutUsDTO对象,以参数AboutUsDTO对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AboutUsDTO selectAboutUsDTOByObj(AboutUsDTO obj);
	/**
	 * 通过AboutUsDTO的id获得AboutUsDTO对象
	 * @param id
	 * @return
	 */
    AboutUsDTO selectAboutUsDTOById(Long id);
	/**
	 * 插入AboutUsDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAboutUsDTO(AboutUsDTO value);
	/**
	 * 插入AboutUsDTO中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAboutUsDTO(AboutUsDTO value);
	/**
	 * 批量插入AboutUsDTO到数据库
	 * @param value
	 * @return
	 */
    int insertAboutUsDTOByBatch(List<AboutUsDTO> value);
	/**
	 * 通过AboutUsDTO的id删除AboutUsDTO
	 * @param id
	 * @return
	 */
    int deleteAboutUsDTOById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AboutUsDTO
	 * @param assist
	 * @return
	 */
    int deleteAboutUsDTO(Assist assist);
	/**
	 * 通过AboutUsDTO的id更新AboutUsDTO中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAboutUsDTOById(AboutUsDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新AboutUsDTO中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAboutUsDTO(AboutUsDTO value,  Assist assist);
	/**
	 * 通过AboutUsDTO的id更新AboutUsDTO中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAboutUsDTOById(AboutUsDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新AboutUsDTO中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAboutUsDTO(AboutUsDTO value, Assist assist);
}