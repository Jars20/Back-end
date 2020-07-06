package club.banyuan.service.impl;

import club.banyuan.dao.AddressDao;
import club.banyuan.dao.impl.AddressDaoImpl;
import club.banyuan.entity.Address;
import club.banyuan.util.JdbcUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressServiceImpl implements club.banyuan.service.AddressService {
    @Override
    public List<Address> getAddressbyUserId(int userId) throws Exception {

        AddressDao addressDao = new AddressDaoImpl(JdbcUtils.getConnection());
        return addressDao.getAddressbyUserId(userId);
    }
}
