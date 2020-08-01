package com.regex.admin.dao.web;
import com.regex.admin.common.dto.web.RecruitDTO;
import java.util.List;
import com.regex.admin.common.util.Assist;
import org.apache.ibatis.annotations.Param;
public interface IRecruitDao{
	/**
	 * 获得RecruitDTO数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getRecruitDTORowCount(Assist assist);
	/**
	 * 获得RecruitDTO数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<RecruitDTO> selectRecruitDTO(Assist assist);
	/**
	 * 获得一个RecruitDTO对象,以参数RecruitDTO对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    RecruitDTO selectRecruitDTOByObj(RecruitDTO obj);
	/**
	 * 通过RecruitDTO的id获得RecruitDTO对象
	 * @param id
	 * @return
	 */
    RecruitDTO selectRecruitDTOById(Long id);
	/**
	 * 插入RecruitDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertRecruitDTO(RecruitDTO value);
	/**
	 * 插入RecruitDTO中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyRecruitDTO(RecruitDTO value);
	/**
	 * 批量插入RecruitDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertRecruitDTOByBatch(List<RecruitDTO> value);
	/**
	 * 通过RecruitDTO的id删除RecruitDTO
	 * @param id
	 * @return
	 */
    int deleteRecruitDTOById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除RecruitDTO
	 * @param assist
	 * @return
	 */
    int deleteRecruitDTO(Assist assist);
	/**
	 * 通过RecruitDTO的id更新RecruitDTO中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateRecruitDTOById(RecruitDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新RecruitDTO中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateRecruitDTO(@Param("enti") RecruitDTO value, @Param("assist") Assist assist);
	/**
	 * 通过RecruitDTO的id更新RecruitDTO中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyRecruitDTOById(RecruitDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新RecruitDTO中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyRecruitDTO(@Param("enti") RecruitDTO value, @Param("assist") Assist assist);
}