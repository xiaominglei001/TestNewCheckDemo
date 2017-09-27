package testnewcheck.com.testnewcheckdemo;

import android.text.TextUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ID生成器
 * @author Administrator
 *
 */
public class IDGenerator {
	private final static Lock LOCK = new ReentrantLock();
	private final static Condition PAUSE  = LOCK.newCondition(); 

	/**
	 * 简单生成
	 * @return
	 */
	public static String simple() {
		return simple(null);
       
    } 
	/**
	 * 简单生成
	 * @return
	 */
	public static String simple(String prefix) {
		try {
			LOCK.lock();
			PAUSE.await(1, TimeUnit.MILLISECONDS);
			if (TextUtils.isEmpty(prefix)) {
				return String.valueOf(System.currentTimeMillis());
			} else {
				return prefix + System.currentTimeMillis();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			LOCK.unlock();
		}
       
    } 
}
