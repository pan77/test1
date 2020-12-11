package other.observer;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 使用RxJava2实现一个观察者
 * 
 * @author xuwenjin 2020年11月15日
 */
public class Rxjava2Observer<T> implements Observer<T> {

	/**sleep时长(单位毫秒)*/
	private long sleepTime;

	public Rxjava2Observer(long sleepTime) {
		this.sleepTime = sleepTime;
	}

	@Override
	public void onSubscribe(Disposable d) {
		// System.out.println("onSubscribe: " + d);
	}

	@Override
	public void onNext(T s) {
		System.out.println(Thread.currentThread().getName() + "----收到消息---->" + s);
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}

	@Override
	public void onError(Throwable e) {
		System.out.println("onError: " + e);
	}

	@Override
	public void onComplete() {
		System.out.println("onComplete");
	}

}
