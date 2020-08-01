package com.regex.admin.service.web.impl;
import java.util.List;
import com.regex.admin.dao.web.IBannerDao;
import com.regex.admin.common.dto.web.BannerDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BannerServiceImpl implements IBannerService{
    @Autowired
    private IBannerDao iBannerDao;
    @Override
    public long getBannerDTORowCount(Assist assist){
        return iBannerDao.getBannerDTORowCount(assist);
    }
    @Override
    public List<BannerDTO> selectBannerDTO(Assist assist){
        return iBannerDao.selectBannerDTO(assist);
    }
    @Override
    public BannerDTO selectBannerDTOByObj(BannerDTO obj){
        return iBannerDao.selectBannerDTOByObj(obj);
    }
    @Override
    public BannerDTO selectBannerDTOById(Long id){
        return iBannerDao.selectBannerDTOById(id);
    }
    @Override
    public int insertBannerDTO(BannerDTO value){
        return iBannerDao.insertBannerDTO(value);
    }
    @Override
    public int insertNonEmptyBannerDTO(BannerDTO value){
        return iBannerDao.insertNonEmptyBannerDTO(value);
    }
    @Override
    public int insertBannerDTOByBatch(List<BannerDTO> value){
        return iBannerDao.insertBannerDTOByBatch(value);
    }
    @Override
    public int deleteBannerDTOById(Long id){
        return iBannerDao.deleteBannerDTOById(id);
    }
    @Override
    public int deleteBannerDTO(Assist assist){
        return iBannerDao.deleteBannerDTO(assist);
    }
    @Override
    public int updateBannerDTOById(BannerDTO enti){
        return iBannerDao.updateBannerDTOById(enti);
    }
    @Override
    public int updateBannerDTO(BannerDTO value, Assist assist){
        return iBannerDao.updateBannerDTO(value,assist);
    }
    @Override
    public int updateNonEmptyBannerDTOById(BannerDTO enti){
        return iBannerDao.updateNonEmptyBannerDTOById(enti);
    }
    @Override
    public int updateNonEmptyBannerDTO(BannerDTO value, Assist assist){
        return iBannerDao.updateNonEmptyBannerDTO(value,assist);
    }

    public IBannerDao getIBannerDao() {
        return this.iBannerDao;
    }

    public void setIBannerDao(IBannerDao iBannerDao) {
        this.iBannerDao = iBannerDao;
    }

}