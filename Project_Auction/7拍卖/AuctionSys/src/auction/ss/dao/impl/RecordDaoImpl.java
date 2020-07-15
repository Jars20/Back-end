package auction.ss.dao.impl;

import auction.ss.dao.IRecordDao;
import auction.ss.entity.Record;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author WM
 * @date 2020/7/12 11:05 下午
 * 描述信息：
 */
public class RecordDaoImpl extends BaseDaoImpl implements IRecordDao {
    public RecordDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int addRecord(Record record) throws ParseException {
        String sql = "insert into `Record` values(null,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("新增的record： "+record );

        int i = executeInsert(sql, new Object[]{
                record.getUserId(),
                record.getProductId(),
                format.parse(record.getTime()),
                record.getPrice()
        });
        return i;
    }

    @Override
    public Record tableToClass(ResultSet rs) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Record record = new Record(
                rs.getInt("id"),
                rs.getInt("userId"),
                rs.getInt("productId"),
                rs.getDouble("price"),
                format.format(rs.getTimestamp("time"))
        );
        return record;
    }
}
