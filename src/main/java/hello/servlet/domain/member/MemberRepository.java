package hello.servlet.domain.member;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    // 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
    private static Map<Long, Member> store = new HashMap<>(); // static 으로 싱글톤 유지 (공유)
    private static Long sequence = 0L; // static 으로 싱글톤 유지 (공유)


    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){
    }


    // 이름 - save
    // 매개변수 - member
    // 동작 - 이 함수가 실행될때 sequence 값을 올리고, member 의 Id 에 할당, 저장소에 매개변수로 받은 member put 넣기
    // 반환값 -
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }


    // 이름 - findById
    // 매개변수 - id
    // 동작 - 매개변수 id 를 이용해서 멤버를 찾는다
    // 반환값 - 동작으로 찾은 멤버를 반환한다.
    public Member findById(Long id){
        return store.get(id);
    }


    // 이름 - findAll
    // 매개변수 - x
    // 동작 - 저장소에 있는 값들을 ArrayList 로 전부 뽑는다
    // 반환값 - 동작값으로 받은 Member 값들을 List 로 반환한다.
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    // 저장소를 비운다.
    public void clearStore(){
        store.clear();
    }
}
