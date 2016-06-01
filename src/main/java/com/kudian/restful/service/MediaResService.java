package com.kudian.restful.service;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.service.BaseService;
import com.kudian.common.utils.FileNameUtils;
import com.kudian.common.utils.StringUtils;
import com.kudian.common.utils.UUIDGenerator;
import com.kudian.restful.dao.LoginSessionDao;
import com.kudian.restful.dao.MediaResDao;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.MediaRes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/14.
 */
@Service
@Transactional(readOnly = true)
public class MediaResService extends BaseService<MediaRes, String> {

    private static final Logger logger = Logger.getLogger(MediaResService.class);

    // local
    // private static final String pre = "http://localhost:8080/upload/";

    // remote
    private static final String pre = "http://101.201.74.2/upload/";

    @Autowired
    private MediaResDao mediaResDao;

    @Autowired
    private LoginSessionDao loginSessionDao;

    @Override
    public HibernateDao<MediaRes, String> getEntityDao() {
        return mediaResDao;
    }

    @Transactional(readOnly=false)
    public String saveMedia(String access_token, String fileName, long fileSize) {

        LoginSession lgnsession = loginSessionDao.find(access_token);
        MediaRes entity = new MediaRes();
        final String uuid = UUIDGenerator.getUUID();
        entity.setMediaId(uuid);
        entity.setUserId(lgnsession.getUserId());
        entity.setFileName(fileName);
        entity.setFileSize(fileSize);
        entity.setLastTime(new Timestamp(System.currentTimeMillis()));

        mediaResDao.save(entity);
        return uuid;
    }

    /**
     * 根据资源主键获得地址
     * @param uuid
     * @return
     */
    public String getResUrl(String uuid) {

        MediaRes mr = mediaResDao.get(uuid);
        if (mr == null)
            return uuid;

        String ext = FileNameUtils.getExtName(mr.getFileName());
        if (StringUtils.isNotBlank(ext)) {
            return pre + mr.getMediaId() + "." + FileNameUtils.getExtName(mr.getFileName());
        } else {
            return pre + mr.getMediaId();
        }
    }

    /**
     * 根据资源主键集合获得地址
     * @param uuids
     * @return
     */
    public String getResUrls(String uuids) {
        if (StringUtils.isBlank(uuids)) {
            return "";
        }

        String ret = "";
        String[] us = uuids.split(",");
        boolean isfirst = true;
        for (String uuid : us) {
            MediaRes mr = mediaResDao.get(uuid);

            String fileurl = "";

            if (mr == null) {
                fileurl = uuid;
            } else {
                // fileurl = pre + mr.getMediaId() + "." + FileNameUtils.getExtName(mr.getFileName());
                String ext = FileNameUtils.getExtName(mr.getFileName());
                if (StringUtils.isNotBlank(ext)) {
                    fileurl = pre + mr.getMediaId() + "." + FileNameUtils.getExtName(mr.getFileName());
                } else {
                    fileurl = pre + mr.getMediaId();
                }
            }

            if (isfirst) {
                ret += fileurl;
                isfirst = false;
            } else {
                ret += "," + fileurl;
            }
        }
        return ret;
    }
}
