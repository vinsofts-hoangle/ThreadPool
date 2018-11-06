package com.vinsofts.thread.ThreadPool;

import android.content.Context;

import com.vinsofts.thread.Constant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolManager {
    public static ThreadPoolManager newInstance(Context context) {
        ThreadPoolManager threadPoolManager = new ThreadPoolManager(context);
        return threadPoolManager;
    }

    private ThreadPoolManager(Context context) {
        BlockingQueue<Runnable> mQueue= new LinkedBlockingQueue<>();
        ThreadPoolExecutor mLoadInfor =
                new ThreadPoolExecutor(Constant.CORE_POOL_SIZE, Constant.MAXIMUM_POOL_SIZE,
                Constant.KEEP_ALIVE_TIME, Constant.KEEP_ALIVE_TIME_UNIT, mQueue);
        for (int i = 0; i < Constant.list.length; i++) {
            mLoadInfor.execute(new LoadInforRunnable(i,context));
        }
    }

}
