package com.lzh.common.model.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
public class RestfulRequest implements Request {
    private static final long serialVersionUID = -2363877433041183308L;
    
    /**
     * mysql分页参数
     * 偏移量
     */
    public int offset = -1;
    /**
     * mysql分页参数
     * 数据量
     */
    public int limited = -1 ;
    
    
}
