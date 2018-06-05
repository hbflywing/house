package com.shawn.house.web.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Price {
    @Id
    private String id;

    private String buildNo;

    private String projectNo;

    private String code;

    private byte[] content;

    private String stringPrice;
}
