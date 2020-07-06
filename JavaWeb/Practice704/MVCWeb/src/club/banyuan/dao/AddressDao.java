package club.banyuan.dao;

import club.banyuan.entity.Address;
import java.util.List;

public interface AddressDao extends IBaseDao{
    List<Address> getAddressbyUserId(int userId) throws Exception;
}
