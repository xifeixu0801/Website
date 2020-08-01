package com.regex.admin.service.web.impl;
import java.util.List;
import com.regex.admin.dao.web.IMessageDao;
import com.regex.admin.common.dto.web.MessageDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MessageServiceImpl implements IMessageService{
    @Autowired
    private IMessageDao iMessageDao;
    @Override
    public long getMessageDTORowCount(Assist assist){
        return iMessageDao.getMessageDTORowCount(assist);
    }
    @Override
    public List<MessageDTO> selectMessageDTO(Assist assist){
        return iMessageDao.selectMessageDTO(assist);
    }
    @Override
    public MessageDTO selectMessageDTOByObj(MessageDTO obj){
        return iMessageDao.selectMessageDTOByObj(obj);
    }
    @Override
    public MessageDTO selectMessageDTOById(Long id){
        return iMessageDao.selectMessageDTOById(id);
    }
    @Override
    public int insertMessageDTO(MessageDTO value){
        return iMessageDao.insertMessageDTO(value);
    }
    @Override
    public int insertNonEmptyMessageDTO(MessageDTO value){
        return iMessageDao.insertNonEmptyMessageDTO(value);
    }
    @Override
    public int insertMessageDTOByBatch(List<MessageDTO> value){
        return iMessageDao.insertMessageDTOByBatch(value);
    }
    @Override
    public int deleteMessageDTOById(Long id){
        return iMessageDao.deleteMessageDTOById(id);
    }
    @Override
    public int deleteMessageDTO(Assist assist){
        return iMessageDao.deleteMessageDTO(assist);
    }
    @Override
    public int updateMessageDTOById(MessageDTO enti){
        return iMessageDao.updateMessageDTOById(enti);
    }
    @Override
    public int updateMessageDTO(MessageDTO value, Assist assist){
        return iMessageDao.updateMessageDTO(value,assist);
    }
    @Override
    public int updateNonEmptyMessageDTOById(MessageDTO enti){
        return iMessageDao.updateNonEmptyMessageDTOById(enti);
    }
    @Override
    public int updateNonEmptyMessageDTO(MessageDTO value, Assist assist){
        return iMessageDao.updateNonEmptyMessageDTO(value,assist);
    }

    public IMessageDao getIMessageDao() {
        return this.iMessageDao;
    }

    public void setIMessageDao(IMessageDao iMessageDao) {
        this.iMessageDao = iMessageDao;
    }

}