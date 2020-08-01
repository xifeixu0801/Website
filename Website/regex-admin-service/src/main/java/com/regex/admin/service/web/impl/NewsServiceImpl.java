package com.regex.admin.service.web.impl;
import java.util.List;
import com.regex.admin.dao.web.INewsDao;
import com.regex.admin.common.dto.web.NewsDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NewsServiceImpl implements INewsService{
    @Autowired
    private INewsDao iNewsDao;
    @Override
    public long getNewsDTORowCount(Assist assist){
        return iNewsDao.getNewsDTORowCount(assist);
    }
    @Override
    public List<NewsDTO> selectNewsDTO(Assist assist){
        return iNewsDao.selectNewsDTO(assist);
    }
    @Override
    public NewsDTO selectNewsDTOByObj(NewsDTO obj){
        return iNewsDao.selectNewsDTOByObj(obj);
    }
    @Override
    public NewsDTO selectNewsDTOById(Long id){
        return iNewsDao.selectNewsDTOById(id);
    }
    @Override
    public int insertNewsDTO(NewsDTO value){
        return iNewsDao.insertNewsDTO(value);
    }
    @Override
    public int insertNonEmptyNewsDTO(NewsDTO value){
        return iNewsDao.insertNonEmptyNewsDTO(value);
    }
    @Override
    public int insertNewsDTOByBatch(List<NewsDTO> value){
        return iNewsDao.insertNewsDTOByBatch(value);
    }
    @Override
    public int deleteNewsDTOById(Long id){
        return iNewsDao.deleteNewsDTOById(id);
    }
    @Override
    public int deleteNewsDTO(Assist assist){
        return iNewsDao.deleteNewsDTO(assist);
    }
    @Override
    public int updateNewsDTOById(NewsDTO enti){
        return iNewsDao.updateNewsDTOById(enti);
    }
    @Override
    public int updateNewsDTO(NewsDTO value, Assist assist){
        return iNewsDao.updateNewsDTO(value,assist);
    }
    @Override
    public int updateNonEmptyNewsDTOById(NewsDTO enti){
        return iNewsDao.updateNonEmptyNewsDTOById(enti);
    }
    @Override
    public int updateNonEmptyNewsDTO(NewsDTO value, Assist assist){
        return iNewsDao.updateNonEmptyNewsDTO(value,assist);
    }

    public INewsDao getINewsDao() {
        return this.iNewsDao;
    }

    public void setINewsDao(INewsDao iNewsDao) {
        this.iNewsDao = iNewsDao;
    }

}