package com.lzh.common.model.entity;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lzh.common.model.dto.IdentityDomain;
import com.lzh.common.util.converter.jackson.OffsetDateTimeToIso8601Serializer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 标识Domain并且限定CrudService边界
 *
 * @author 
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
public class BasicDomain extends IdentityDomain {

    private static final long serialVersionUID = 6404939125344686735L;

    @JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
    @Override
    public OffsetDateTime getCreateTime() {
        return super.getCreateTime();
    }

    @JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
    @Override
    public OffsetDateTime getUpdateTime() {
        return super.getUpdateTime();
    }

    @JsonSerialize(using = OffsetDateTimeToIso8601Serializer.class)
    @Override
    public OffsetDateTime getDeleteTime() {
        return super.getDeleteTime();
    }
}

