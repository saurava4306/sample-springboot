package com.sample.aspect;

import com.sample.domain.CustomerEntity;
import com.sample.exception.BadRequestException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RecordNotFoundAspect {

    @Around("@annotation(com.sample.aspect.CustomerPhoneAlreadyRegisteredHandler)")
    public Object handleRecordNotFound(ProceedingJoinPoint joinPoint) throws Throwable{
        CustomerEntity customerEntity = (CustomerEntity) joinPoint.proceed();

        if(customerEntity != null){
           throw new BadRequestException("Customer Phone number already registered!");
        }
        return null;
    }
}
