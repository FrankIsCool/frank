package com.sxmaps.my.utils;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 唯一id工具类
 * 
 * @author chendehua
 *
 */
public class SequenceUtil {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	private static final SequenceUtil instance = new SequenceUtil();

	private SequenceUtil() {
	}

	public static SequenceUtil getInstance() {
		return instance;
	}

	/**
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	public String createSn() throws Exception {
		try {
			lock.readLock().lock();
			final IdGen gen = IdGen.getInStance();
			return gen.nextId() + "";
		} finally {
			lock.readLock().unlock();
		}
	}
}
