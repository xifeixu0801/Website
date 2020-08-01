package com.regex.admin.service.web.impl;
import java.util.List;
import com.regex.admin.dao.web.IPartnerDao;
import com.regex.admin.common.dto.web.PartnerDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PartnerServiceImpl implements IPartnerService{
    @Autowired
    private IPartnerDao iPartnerDao;
    @Override
    public long getPartnerDTORowCount(Assist assist){
        return iPartnerDao.getPartnerDTORowCount(assist);
    }
    @Override
    public List<PartnerDTO> selectPartnerDTO(Assist assist){
        return iPartnerDao.selectPartnerDTO(assist);
    }
    @Override
    public PartnerDTO selectPartnerDTOByObj(PartnerDTO obj){
        return iPartnerDao.selectPartnerDTOByObj(obj);
    }
    @Override
    public PartnerDTO selectPartnerDTOById(Long id){
        return iPartnerDao.selectPartnerDTOById(id);
    }
    @Override
    public int insertPartnerDTO(PartnerDTO value){
        return iPartnerDao.insertPartnerDTO(value);
    }
    @Override
    public int insertNonEmptyPartnerDTO(PartnerDTO value){
        return iPartnerDao.insertNonEmptyPartnerDTO(value);
    }
    @Override
    public int insertPartnerDTOByBatch(List<PartnerDTO> value){
        return iPartnerDao.insertPartnerDTOByBatch(value);
    }
    @Override
    public int deletePartnerDTOById(Long id){
        return iPartnerDao.deletePartnerDTOById(id);
    }
    @Override
    public int deletePartnerDTO(Assist assist){
        return iPartnerDao.deletePartnerDTO(assist);
    }
    @Override
    public int updatePartnerDTOById(PartnerDTO enti){
        return iPartnerDao.updatePartnerDTOById(enti);
    }
    @Override
    public int updatePartnerDTO(PartnerDTO value, Assist assist){
        return iPartnerDao.updatePartnerDTO(value,assist);
    }
    @Override
    public int updateNonEmptyPartnerDTOById(PartnerDTO enti){
        return iPartnerDao.updateNonEmptyPartnerDTOById(enti);
    }
    @Override
    public int updateNonEmptyPartnerDTO(PartnerDTO value, Assist assist){
        return iPartnerDao.updateNonEmptyPartnerDTO(value,assist);
    }

    public IPartnerDao getIPartnerDao() {
        return this.iPartnerDao;
    }

    public void setIPartnerDao(IPartnerDao iPartnerDao) {
        this.iPartnerDao = iPartnerDao;
    }

}