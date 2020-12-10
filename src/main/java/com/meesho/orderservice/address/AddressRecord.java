package com.meesho.orderservice.address;

import com.meesho.orderservice.common.Record;
import lombok.Data;

@Data
public class AddressRecord implements Record {
    private String id;
    private String pincode;
}
