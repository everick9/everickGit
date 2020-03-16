package com.spring.web.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class BoardEnty {
    
    private int bbsno;
    private String wname;
    private String subject;
    private String content;
    private String passwd;
    private int readcnt;
    private String regdt;

}
