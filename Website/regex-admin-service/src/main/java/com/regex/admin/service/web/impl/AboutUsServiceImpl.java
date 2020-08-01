package com.regex.admin.service.web.impl;
import java.util.List;
import com.regex.admin.dao.web.IAboutUsDao;
import com.regex.admin.common.dto.web.AboutUsDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IAboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AboutUsServiceImpl implements IAboutUsService{
    @Autowired
    private IAboutUsDao iAboutUsDao;
    @Override
    public long getAboutUsDTORowCount(Assist assist){
        return iAboutUsDao.getAboutUsDTORowCount(assist);
    }
    @Override
    public List<AboutUsDTO> selectAboutUsDTO(Assist assist){
        return iAboutUsDao.selectAboutUsDTO(assist);
    }
    @Override
    public AboutUsDTO selectAboutUsDTOByObj(AboutUsDTO obj){
        return iAboutUsDao.selectAboutUsDTOByObj(obj);
    }
    @Override
    public AboutUsDTO selectAboutUsDTOById(Long id){
        return iAboutUsDao.selectAboutUsDTOById(id);
    }
    @Override
    public int insertAboutUsDTO(AboutUsDTO value){
        return iAboutUsDao.insertAboutUsDTO(value);
    }
    @Override
    public int insertNonEmptyAboutUsDTO(AboutUsDTO value){
        return iAboutUsDao.insertNonEmptyAboutUsDTO(value);
    }
    @Override
    public int insertAboutUsDTOByBatch(List<AboutUsDTO> value){
        return iAboutUsDao.insertAboutUsDTOByBatch(value);
    }
    @Override
    public int deleteAboutUsDTOById(Long id){
        return iAboutUsDao.deleteAboutUsDTOById(id);
    }
    @Override
    public int deleteAboutUsDTO(Assist assist){
        return iAboutUsDao.deleteAboutUsDTO(assist);
    }
    @Override
    public int updateAboutUsDTOById(AboutUsDTO enti){
        return iAboutUsDao.updateAboutUsDTOById(enti);
    }
    @Override
    public int updateAboutUsDTO(AboutUsDTO value, Assist assist){
        return iAboutUsDao.updateAboutUsDTO(value,assist);
    }
    @Override
    public int updateNonEmptyAboutUsDTOById(AboutUsDTO enti){
        return iAboutUsDao.updateNonEmptyAboutUsDTOById(enti);
    }
    @Override
    public int updateNonEmptyAboutUsDTO(AboutUsDTO value, Assist assist){
        return iAboutUsDao.updateNonEmptyAboutUsDTO(value,assist);
    }

    public IAboutUsDao getIAboutUsDao() {
        return this.iAboutUsDao;
    }

    public void setIAboutUsDao(IAboutUsDao iAboutUsDao) {
        this.iAboutUsDao = iAboutUsDao;
    }

}