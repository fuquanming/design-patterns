package com.demo.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 10:43
 * @version: V1.0
 * @detail:
 **/
@Slf4j
public class XmlAspect {
    /**
     * ����ǰ��֪ͨ��ʹ�÷���aspect()��ע��������
     * ͬʱ����JoinPoint�������󣬿���û�в���
     * @param joinPoint
     */
    public void before(JoinPoint joinPoint){
        log.info("" + joinPoint.getArgs() );//��ȡʵ���б�
        log.info("" + joinPoint.getKind()); //���ӵ����ͣ���method-execution
        log.info(""+joinPoint.getSignature()); //��ȡ�����õ��е�
        log.info(""+joinPoint.getTarget());//��ȡĿ�����
        log.info(""+joinPoint.getThis());//��ȡthis��ֵ

        log.info("before֪ͨ"+joinPoint);
    }

    //���ú���֪ͨ��ʹ�÷�����aspect()ע��������
    public void after(JoinPoint joinPoint){
        log.info("after֪ͨ"+joinPoint);
    }

    //���û���֪ͨ��ʹ�÷���aspect()��ע��������
    public void around(JoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try{
            ((ProceedingJoinPoint)joinPoint).proceed();
            long end = System.currentTimeMillis();
            log.info("around֪ͨ"+joinPoint+"\tUse time��"+(end - start)+"ms!");
        }catch (Throwable e){
            long end = System.currentTimeMillis();
            log.info("around֪ͨ"+joinPoint+"\tUse time:"+(end -start)+":ms with exception"+e.getMessage());
        }
    }

    //���ú���֪ͨ��ʹ�÷�����aspect()��ע��������
    public void afterReturn(JoinPoint joinPoint){
        log.info("afterReturn֪ͨ"+joinPoint);
    }

    //�����׳��쳣��֪ͨ��ʹ���ٷ���aspect()��ע��������
    public void afterThrow(JoinPoint joinPoint,Exception e){
        log.info("afterThrow֪ͨ"+joinPoint+"\t"+e.getMessage());
    }


}