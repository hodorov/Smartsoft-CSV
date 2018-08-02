package com.smartsoft.main.model;

import com.smartsoft.main.service.DateConverterService;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Record {

    @Id
    @GeneratedValue
    private Long id;
    private String ssoid;
    private String ts;
    private String grp;
    private String type;
    private String subtype;
    private String url;
    private String orgid;
    private String formid;
    private String code;
    private String ltpa;
    private String sudirresponse;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ymdh;

    public Record() {
    }

    public Record(String recordData) {
        /*
        ;           // Split on semicolon
        (?=         // Followed by
           (?:      // Start a non-capture group
             [^"]*  // 0 or more non-quote characters
             "      // 1 quote
             [^"]*  // 0 or more non-quote characters
             "      // 1 quote
           )*       // 0 or more repetition of non-capture group (multiple of 2 quotes will be even)
           [^"]*    // Finally 0 or more non-quotes
           $        // Till the end (This is necessary, else every comma will satisfy the condition)
        )
         */
        String[] splittedData = recordData.split(";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        this.ssoid = splittedData[0];
        this.ts = splittedData[1];
        this.grp = splittedData[2];
        this.type = splittedData[3];
        this.subtype = splittedData[4];
        this.url = splittedData[5];
        this.orgid = splittedData[6];
        this.formid = splittedData[7];
        this.code = splittedData[8];
        this.ltpa = splittedData[9];
        this.sudirresponse = splittedData[10];
        this.ymdh = DateConverterService.convertFromCSVFormat(splittedData[11]);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSudirresponse() {
        return sudirresponse;
    }

    public void setSudirresponse(String sudirresponse) {
        this.sudirresponse = sudirresponse;
    }

    public Date getYmdh() {
        return ymdh;
    }

    public void setYmdh(Date ymdh) {
        this.ymdh = ymdh;
    }
}