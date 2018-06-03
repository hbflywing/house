package com.shawn.house.common;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Price {
    @Id
    private String id;

    private String code;

    private byte[] content;

    private String stringPrice;
}
