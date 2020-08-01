package com.regex.admin.service.web.impl;
import java.util.List;
import com.regex.admin.dao.web.IRecruitDao;
import com.regex.admin.common.dto.web.RecruitDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RecruitServiceImpl implements IRecruitService{
    @Autowired
    private IRecruitDao iRecruitDao;
    @Override
    public long getRecruitDTORowCount(Assist assist){
        return iRecruitDao.getRecruitDTORowCount(assist);
    }
    @Override
    public List<RecruitDTO> selectRecruitDTO(Assist assist){
        return iRecruitDao.selectRecruitDTO(assist);
    }
    @Override
    public RecruitDTO selectRecruitDTOByObj(RecruitDTO obj){
        return iRecruitDao.selectRecruitDTOByObj(obj);
    }
    @Override
    public RecruitDTO selectRecruitDTOById(Long id){
        return iRecruitDao.selectRecruitDTOById(id);
    }
    @Override
    public int insertRecruitDTO(RecruitDTO value){
        return iRecruitDao.insertRecruitDTO(value);
    }
    @Override
    public int insertNonEmptyRecruitDTO(RecruitDTO value){
        return iRecruitDao.insertNonEmptyRecruitDTO(value);
    }
    @Override
    public int insertRecruitDTOByBatch(List<RecruitDTO> value){
        return iRecruitDao.insertRecruitDTOByBatch(value);
    }
    @Override
    public int deleteRecruitDTOById(Long id){
        return iRecruitDao.deleteRecruitDTOById(id);
    }
    @Override
    public int deleteRecruitDTO(Assist assist){
        return iRecruitDao.deleteRecruitDTO(assist);
    }
    @Override
    public int updateRecruitDTOById(RecruitDTO enti){
        return iRecruitDao.updateRecruitDTOById(enti);
    }
    @Override
    public int updateRecruitDTO(RecruitDTO value, Assist assist){
        return iRecruitDao.updateRecruitDTO(value,assist);
    }
    @Override
    public int updateNonEmptyRecruitDTOById(RecruitDTO enti){
        return iRecruitDao.updateNonEmptyRecruitDTOById(enti);
    }
    @Override
    public int updateNonEmptyRecruitDTO(RecruitDTO value, Assist assist){
        return iRecruitDao.updateNonEmptyRecruitDTO(value,assist);
    }

    public IRecruitDao getIRecruitDao() {
        return this.iRecruitDao;
    }

    public void setIRecruitDao(IRecruitDao iRecruitDao) {
        this.iRecruitDao = iRecruitDao;
    }

}