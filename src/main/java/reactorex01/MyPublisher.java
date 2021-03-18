package reactorex01;

import java.util.Arrays;
import java.util.Iterator;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

// <T> 발행할 데이터의 타입
public class MyPublisher implements Publisher<Integer>{
	
	//데이터베이스 - 정보를 가지고 있음
	Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

	// 구독, 이 함수는 구독자가 호출
	public void subscribe(Subscriber<? super Integer> s) {
		
		System.out.println("1.MyPublisher-구독");
		s.onSubscribe(new MySubscription((MySubscriber)s,its)); // 구독 정보를 넘겨줘야함 Subscription 구독자에게 돌려줌
	}
}