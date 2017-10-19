package com.wangmaodou.leavesid.core.impl;

import com.wangmaodou.leavesid.core.IdFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Maodou on 2017/10/19.
 * <p>
 * Total length 64 bit;
 * Sign 1 bit;
 * Id_Version 2 bit;
 * TimeStamp 41 bit;
 * Machine Code 5 bit;
 * Index 15 bit;
 */
@Component
@Scope(scopeName = "singleton")
public class LeavesIdFactory implements IdFactory {

    private static final long ID_VERSION = 0 << 61;
    private static final long ID_MACHINE_CODE = 1 << 15;

    private long lastTime = 0l;
    private long index = 0l;


    @Override
    public long create() {
        long time = System.currentTimeMillis();
        return ID_VERSION |
                time << 20 |
                ID_MACHINE_CODE |
                getIndex(time);
    }

    private synchronized long getIndex(long currentTime) {
        if (currentTime == lastTime) {
            index++;
        } else {
            lastTime=currentTime;
            index = 0;
        }
        return index;
    }

}
