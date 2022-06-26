package com.example.configurator.db.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

@Getter
@Setter
@MappedSuperclass
public class DefaultEntity {

    @NotNull
    @Type(type="yes_no")
    @Column(name="actv_flg")
    protected Boolean status;

    @NotNull
    @Column(name="crt_id")
    protected String createdBy;

    @NotNull
    @Column(name="crt_ts")
    protected OffsetDateTime createDate;

    @Column(name="upd_id")
    protected String updatedBy;

    @Column(name="upd_ts")
    protected OffsetDateTime updateDate;

}
