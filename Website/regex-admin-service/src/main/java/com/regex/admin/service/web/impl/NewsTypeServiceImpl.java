package com.regex.admin.service.web.impl;
import java.util.List;
import com.regex.admin.dao.web.INewsTypeDao;
import com.regex.admin.common.dto.web.NewsTypeDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.INewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NewsTypeServiceImpl implements INewsTypeService{
    @Autowired
    private INewsTypeDao iNewsTypeDao;
    @Override
    public long getNewsTypeDTORowCount(Assist assist){
        return iNewsTypeDao.getNewsTypeDTORowCount(assist);
    }
    @Override
    public List<NewsTypeDTO> selectNewsTypeDTO(Assist assist){
        return iNewsTypeDao.selectNewsTypeDTO(assist);
    }
    @Override
    public NewsTypeDTO selectNewsTypeDTOByObj(NewsTypeDTO obj){
        return iNewsTypeDao.selectNewsTypeDTOByObj(obj);
    }
    @Override
    public NewsTypeDTO selectNewsTypeDTOById(Long id){
        return iNewsTypeDao.selectNewsTypeDTOById(id);
    }
    @Override
    public int insertNewsTypeDTO(NewsTypeDTO value){
        return iNewsTypeDao.insertNewsTypeDTO(value);
    }
    @Override
    public int insertNonEmptyNewsTypeDTO(NewsTypeDTO value){
        return iNewsTypeDao.insertNonEmptyNewsTypeDTO(value);
    }
    @Override
    public int insertNewsTypeDTOByBatch(List<NewsTypeDTO> value){
        return iNewsTypeDao.insertNewsTypeDTOByBatch(value);
    }
    @Override
    public int deleteNewsTypeDTOById(Long id){
        return iNewsTypeDao.deleteNewsTypeDTOById(id);
    }
    @Override
    public int deleteNewsTypeDTO(Assist assist){
        return iNewsTypeDao.deleteNewsTypeDTO(assist);
    }
    @Override
    public int updateNewsTypeDTOById(NewsTypeDTO enti){
        return iNewsTypeDao.updateNewsTypeDTOById(enti);
    }
    @Override
    public int updateNewsTypeDTO(NewsTypeDTO value, Assist assist){
        return iNewsTypeDao.updateNewsTypeDTO(value,assist);
    }
    @Override
    public int updateNonEmptyNewsTypeDTOById(NewsTypeDTO enti){
        return iNewsTypeDao.updateNonEmptyNewsTypeDTOById(enti);
    }
    @Override
    public int updateNonEmptyNewsTypeDTO(NewsTypeDTO value, Assist assist){
        return iNewsTypeDao.updateNonEmptyNewsTypeDTO(value,assist);
    }

    public INewsTypeDao getINewsTypeDao() {
        return this.iNewsTypeDao;
    }

    public void setINewsTypeDao(INewsTypeDao iNewsTypeDao) {
        this.iNewsTypeDao = iNewsTypeDao;
    }

}