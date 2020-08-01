package com.regex.admin.service.web.impl;
import java.util.List;
import com.regex.admin.dao.web.IWebInfoDao;
import com.regex.admin.common.dto.web.WebInfoDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IWebInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WebInfoServiceImpl implements IWebInfoService{
    @Autowired
    private IWebInfoDao iWebInfoDao;
    @Override
    public long getWebInfoDTORowCount(Assist assist){
        return iWebInfoDao.getWebInfoDTORowCount(assist);
    }
    @Override
    public List<WebInfoDTO> selectWebInfoDTO(Assist assist){
        return iWebInfoDao.selectWebInfoDTO(assist);
    }
    @Override
    public WebInfoDTO selectWebInfoDTOByObj(WebInfoDTO obj){
        return iWebInfoDao.selectWebInfoDTOByObj(obj);
    }
    @Override
    public WebInfoDTO selectWebInfoDTOById(Long id){
        return iWebInfoDao.selectWebInfoDTOById(id);
    }
    @Override
    public int insertWebInfoDTO(WebInfoDTO value){
        return iWebInfoDao.insertWebInfoDTO(value);
    }
    @Override
    public int insertNonEmptyWebInfoDTO(WebInfoDTO value){
        return iWebInfoDao.insertNonEmptyWebInfoDTO(value);
    }
    @Override
    public int insertWebInfoDTOByBatch(List<WebInfoDTO> value){
        return iWebInfoDao.insertWebInfoDTOByBatch(value);
    }
    @Override
    public int deleteWebInfoDTOById(Long id){
        return iWebInfoDao.deleteWebInfoDTOById(id);
    }
    @Override
    public int deleteWebInfoDTO(Assist assist){
        return iWebInfoDao.deleteWebInfoDTO(assist);
    }
    @Override
    public int updateWebInfoDTOById(WebInfoDTO enti){
        return iWebInfoDao.updateWebInfoDTOById(enti);
    }
    @Override
    public int updateWebInfoDTO(WebInfoDTO value, Assist assist){
        return iWebInfoDao.updateWebInfoDTO(value,assist);
    }
    @Override
    public int updateNonEmptyWebInfoDTOById(WebInfoDTO enti){
        return iWebInfoDao.updateNonEmptyWebInfoDTOById(enti);
    }
    @Override
    public int updateNonEmptyWebInfoDTO(WebInfoDTO value, Assist assist){
        return iWebInfoDao.updateNonEmptyWebInfoDTO(value,assist);
    }

    public IWebInfoDao getIWebInfoDao() {
        return this.iWebInfoDao;
    }

    public void setIWebInfoDao(IWebInfoDao iWebInfoDao) {
        this.iWebInfoDao = iWebInfoDao;
    }

}