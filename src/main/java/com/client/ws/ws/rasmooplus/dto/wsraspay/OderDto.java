package com.client.ws.ws.rasmooplus.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OderDto {

    private String id;
    private String customerId;
    private Long discount;
    private String productAcronym;

}
