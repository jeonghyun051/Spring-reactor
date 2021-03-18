package reactorex01;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// <T> 구독 할 데이터의 타입
public class MySubscriber implements Subscriber<Integer>{
	
	private Integer size = 3;
	private Subscription s;
	
	public void onSubscribe(Subscription s) {
		this.s=s;
		System.out.println("3.MySubscriber - 구독 정보 돌려 받음");
		// 신문 줘
		s.request(size); // 개수를 요청하는 이유 : 내가 하루에 읽을 수 있는 글자수가 한계가 있기 때문에, 소화할 수 있는 양만 받음 (백프레셔 = Backpressure)
	}

	//데이터를 돌려받는 함수
	public void onNext(Integer t) {
		System.out.println("onNext-신문" +t);
		size --;
		if(size == 0){
			size = 3;
			s.request(size);
		}
	}

	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public void onComplete() {
		System.out.println("신문 다 받음");
		
	}
}