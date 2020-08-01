package com.regex.admin.dao.web;
import com.regex.admin.common.dto.web.BannerDTO;
import java.util.List;
import com.regex.admin.common.util.Assist;
import org.apache.ibatis.annotations.Param;
public interface IBannerDao{
	/**
	 * 获得BannerDTO数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getBannerDTORowCount(Assist assist);
	/**
	 * 获得BannerDTO数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<BannerDTO> selectBannerDTO(Assist assist);
	/**
	 * 获得一个BannerDTO对象,以参数BannerDTO对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    BannerDTO selectBannerDTOByObj(BannerDTO obj);
	/**
	 * 通过BannerDTO的id获得BannerDTO对象
	 * @param id
	 * @return
	 */
    BannerDTO selectBannerDTOById(Long id);
	/**
	 * 插入BannerDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertBannerDTO(BannerDTO value);
	/**
	 * 插入BannerDTO中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyBannerDTO(BannerDTO value);
	/**
	 * 批量插入BannerDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertBannerDTOByBatch(List<BannerDTO> value);
	/**
	 * 通过BannerDTO的id删除BannerDTO
	 * @param id
	 * @return
	 */
    int deleteBannerDTOById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除BannerDTO
	 * @param assist
	 * @return
	 */
    int deleteBannerDTO(Assist assist);
	/**
	 * 通过BannerDTO的id更新BannerDTO中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateBannerDTOById(BannerDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新BannerDTO中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateBannerDTO(@Param("enti") BannerDTO value, @Param("assist") Assist assist);
	/**
	 * 通过BannerDTO的id更新BannerDTO中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyBannerDTOById(BannerDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新BannerDTO中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyBannerDTO(@Param("enti") BannerDTO value, @Param("assist") Assist assist);
}