package api.util.collection3;

import java.util.HashMap;
import java.util.Map;

public class Test01 {

	public static void main(String[] args) {
		
		// Map<K, V> 
		// - K : Key(이름) - the type of keys maintained by this map
		// - V : Value(값) - the type of mapped values
		
		// ex) int a = 10 
		// -> 	K : a
		// ->	V : 10
		
		// Map의 key는 중복 불가
		
		// Map<K, V>
		// - K(Key)와 V(Value)를 세트로 저장하는 저장소
		// - K는 중복 불가, v는 중복 가능
		// - K만 보면 Set<K>와 같다 (Set에 Value가 하나씩 붙어있는 형태)
		
		// ex) 이름과 나이를 저장하는 저장소
		// K - 이름(String) / V - 나이(Integer)
		//Map<String, Integer> people = new Map<>;	// Map은 인터페이스이기 때문에 인스턴스 생성 불가
		Map<String, Integer> people = new HashMap<>();
		
		// 추가 - .add()는 데이터 1개를 추가하는 명령 - Map에는 없음
		// 추가 - 2개 값이 세트인 값을 추가, .put() 명령으로 추가하도록 설계
		people.put("유재석", 50);
		people.put("박명수", 51);		// 입력 순서 유지 X (HashMap으로 만들었기 때문)
		people.put("정형돈", 44);
		people.put("하하", 42);
		people.put("노홍철", 43);
		
		people.put("하하", 44);		// 중복된 Key가 들어가면 Value가 수정됨 (덮어쓰기)
		
		// 검색 - .contains()가 아니라 key, value별로 각각 존재
		// .containsKey() : key 값을 검색
		System.out.println(people.containsKey("정준하"));
		
		// .containsValue() : value 값을 검색
		System.out.println(people.containsValue(50));
		
		// 제거
		// .remove(Object key) : 해당 key의 key와 value 삭제
		people.remove("노홍철");
		
		// Map의 값 중 하나 추출
		// - 박명수 몇살인가요?
		System.out.println(people.get("박명수"));
		System.out.println(people.get("정준하"));	// null이 나옴 -> 
		
		// 주의 - null이 나올 수 있는 상황이라면 원시형을 사용할 수 없다
		String name = "길";
		//int age = people.get(name);		// 원시형은 null을 저장할 수 없다
		Integer age = people.get(name);		// 래퍼클래스는 null을 저장할 수 있다
		System.out.println("나이 = " + age);
		
		System.out.println(people);
		System.out.println(people.isEmpty());	// Map의 값이 비어있는지
		System.out.println(people.size());		// Map의 크기가 얼마인지
	}
}
