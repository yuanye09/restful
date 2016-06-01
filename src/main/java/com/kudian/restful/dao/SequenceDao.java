package com.kudian.restful.dao;

import com.kudian.common.persistence.HibernateDao;
import com.kudian.common.utils.DateUtils;
import com.kudian.restful.entity.OrderInfo;
import org.apache.log4j.Logger;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/2.
 */
@Repository
public class SequenceDao extends HibernateDao<OrderInfo, Integer>  {

    private static final Logger logger = Logger.getLogger(SequenceDao.class);

    public String getSequence() {

        final Map<String,String> result = new HashMap<String, String>();
        this.getSession().doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql = "{call pro_nextval(?)}";
                CallableStatement proc = null;
                try {
                    proc = connection.prepareCall(sql);
                    proc.registerOutParameter(1, Types.INTEGER);
                    proc.execute();
                    int uid = 0;
                    uid = proc.getInt(1);

                    DecimalFormat df = new DecimalFormat("00000000");
                    logger.info("***UID : " + uid + "!");
                    result.put("ret", DateUtils.getCurrentDate() + df.format(uid));
                } catch (Exception e) {
                    logger.error(e);
                    result.put("ret", "");
                } finally {
                    if (null != proc) {
                        proc.close();
                    }
                }
            }
        });

        return result.get("ret");
    }
}
