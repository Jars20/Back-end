package club.banyuan.dao;


import club.banyuan.entity.Record;

import java.text.ParseException;
import java.util.List;

/**
 * @author WM
 * @date 2020/7/12 10:45 下午
 * 描述信息：
 */
public interface IRecordDao {
    int addRecord(Record record) throws ParseException;
    List<Record> selectRecord(int ProductId);
    Double getHighTempPrice(int productId);
}
