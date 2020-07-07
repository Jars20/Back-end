package club.banyuan.service;

import club.banyuan.entity.Address;
import java.util.List;

public interface AddressService {
    List<Address> getAddressbyUserId(int userId) throws Exception;
}