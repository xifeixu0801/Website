package com.regex.admin.service.web.impl;
import java.util.List;
import com.regex.admin.dao.web.IProductDao;
import com.regex.admin.common.dto.web.ProductDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductDao iProductDao;
    @Override
    public long getProductDTORowCount(Assist assist){
        return iProductDao.getProductDTORowCount(assist);
    }
    @Override
    public List<ProductDTO> selectProductDTO(Assist assist){
        return iProductDao.selectProductDTO(assist);
    }
    @Override
    public ProductDTO selectProductDTOByObj(ProductDTO obj){
        return iProductDao.selectProductDTOByObj(obj);
    }
    @Override
    public ProductDTO selectProductDTOById(Long id){
        return iProductDao.selectProductDTOById(id);
    }
    @Override
    public int insertProductDTO(ProductDTO value){
        return iProductDao.insertProductDTO(value);
    }
    @Override
    public int insertNonEmptyProductDTO(ProductDTO value){
        return iProductDao.insertNonEmptyProductDTO(value);
    }
    @Override
    public int insertProductDTOByBatch(List<ProductDTO> value){
        return iProductDao.insertProductDTOByBatch(value);
    }
    @Override
    public int deleteProductDTOById(Long id){
        return iProductDao.deleteProductDTOById(id);
    }
    @Override
    public int deleteProductDTO(Assist assist){
        return iProductDao.deleteProductDTO(assist);
    }
    @Override
    public int updateProductDTOById(ProductDTO enti){
        return iProductDao.updateProductDTOById(enti);
    }
    @Override
    public int updateProductDTO(ProductDTO value, Assist assist){
        return iProductDao.updateProductDTO(value,assist);
    }
    @Override
    public int updateNonEmptyProductDTOById(ProductDTO enti){
        return iProductDao.updateNonEmptyProductDTOById(enti);
    }
    @Override
    public int updateNonEmptyProductDTO(ProductDTO value, Assist assist){
        return iProductDao.updateNonEmptyProductDTO(value,assist);
    }

    public IProductDao getIProductDao() {
        return this.iProductDao;
    }

    public void setIProductDao(IProductDao iProductDao) {
        this.iProductDao = iProductDao;
    }

}