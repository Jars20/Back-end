package auction.ss.dao;

import auction.ss.entity.Record;

import java.text.ParseException;

/**
 * @author WM
 * @date 2020/7/12 10:45 下午
 * 描述信息：
 */
public interface IRecordDao extends IBaseDao {
    int addRecord(Record record) throws ParseException;
}
