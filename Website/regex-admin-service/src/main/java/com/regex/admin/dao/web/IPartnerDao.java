package com.regex.admin.dao.web;
import com.regex.admin.common.dto.web.PartnerDTO;
import java.util.List;
import com.regex.admin.common.util.Assist;
import org.apache.ibatis.annotations.Param;
public interface IPartnerDao{
	/**
	 * 获得PartnerDTO数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getPartnerDTORowCount(Assist assist);
	/**
	 * 获得PartnerDTO数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<PartnerDTO> selectPartnerDTO(Assist assist);
	/**
	 * 获得一个PartnerDTO对象,以参数PartnerDTO对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    PartnerDTO selectPartnerDTOByObj(PartnerDTO obj);
	/**
	 * 通过PartnerDTO的id获得PartnerDTO对象
	 * @param id
	 * @return
	 */
    PartnerDTO selectPartnerDTOById(Long id);
	/**
	 * 插入PartnerDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertPartnerDTO(PartnerDTO value);
	/**
	 * 插入PartnerDTO中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyPartnerDTO(PartnerDTO value);
	/**
	 * 批量插入PartnerDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertPartnerDTOByBatch(List<PartnerDTO> value);
	/**
	 * 通过PartnerDTO的id删除PartnerDTO
	 * @param id
	 * @return
	 */
    int deletePartnerDTOById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除PartnerDTO
	 * @param assist
	 * @return
	 */
    int deletePartnerDTO(Assist assist);
	/**
	 * 通过PartnerDTO的id更新PartnerDTO中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updatePartnerDTOById(PartnerDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新PartnerDTO中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updatePartnerDTO(@Param("enti") PartnerDTO value, @Param("assist") Assist assist);
	/**
	 * 通过PartnerDTO的id更新PartnerDTO中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyPartnerDTOById(PartnerDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新PartnerDTO中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyPartnerDTO(@Param("enti") PartnerDTO value, @Param("assist") Assist assist);
}