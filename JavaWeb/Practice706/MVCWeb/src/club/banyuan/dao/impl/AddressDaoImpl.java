package club.banyuan.dao.impl;

import club.banyuan.dao.AddressDao;
import club.banyuan.entity.Address;
import club.banyuan.entity.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

    public AddressDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Address> getAddressbyUserId(int userId) throws Exception {
        String sql = "select * from user_address where userId=?";
        ResultSet resultSet = null;
        List<Address> addressList = new ArrayList<>();
        resultSet = executeQuery(sql,new Integer[]{userId});
        while (resultSet.next()){
            addressList.add(tableToClass(resultSet));
        }
        return addressList;
    }

    @Override
    public Address tableToClass(ResultSet rs) throws Exception {
        return new Address(rs.getInt("id"),
                rs.getInt("userId"),
                rs.getString("address"),
                null,
                rs.getInt("isDefault"),
                rs.getString("remark"));
    }
}