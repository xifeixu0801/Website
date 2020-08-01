package com.regex.admin.service.web;
import java.util.List;
import com.regex.admin.common.dto.web.ProductDTO;
import com.regex.admin.common.util.Assist;
public interface IProductService{
	/**
	 * 获得ProductDTO数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getProductDTORowCount(Assist assist);
	/**
	 * 获得ProductDTO数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<ProductDTO> selectProductDTO(Assist assist);
	/**
	 * 获得一个ProductDTO对象,以参数ProductDTO对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    ProductDTO selectProductDTOByObj(ProductDTO obj);
	/**
	 * 通过ProductDTO的id获得ProductDTO对象
	 * @param id
	 * @return
	 */
    ProductDTO selectProductDTOById(Long id);
	/**
	 * 插入ProductDTO到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertProductDTO(ProductDTO value);
	/**
	 * 插入ProductDTO中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyProductDTO(ProductDTO value);
	/**
	 * 批量插入ProductDTO到数据库
	 * @param value
	 * @return
	 */
    int insertProductDTOByBatch(List<ProductDTO> value);
	/**
	 * 通过ProductDTO的id删除ProductDTO
	 * @param id
	 * @return
	 */
    int deleteProductDTOById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除ProductDTO
	 * @param assist
	 * @return
	 */
    int deleteProductDTO(Assist assist);
	/**
	 * 通过ProductDTO的id更新ProductDTO中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateProductDTOById(ProductDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新ProductDTO中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateProductDTO(ProductDTO value,  Assist assist);
	/**
	 * 通过ProductDTO的id更新ProductDTO中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyProductDTOById(ProductDTO enti);
 	/**
	 * 通过辅助工具Assist的条件更新ProductDTO中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyProductDTO(ProductDTO value, Assist assist);
}