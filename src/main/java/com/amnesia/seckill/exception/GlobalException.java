package com.amnesia.seckill.exception;

import com.amnesia.seckill.common.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends Exception{
    private RespBeanEnum respBeanEnum;
}
