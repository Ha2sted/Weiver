package datasever.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import entity.Musical;

@Repository
public interface ActorRepository extends MongoRepository<Musical, String>{
	
	// 배우 이름, 캐스팅 뮤지컬 제목, 날짜가 일치하는 배우의 ID 반환
	@Query(value = "{'name': ?0, 'castings.title': ?1, 'castings.stDate': {$date: ?2}, 'castings.edDate': {$date: ?3}}", fields = "{'_id': 1}")
    List<String> findActorIdsByNameAndCasting(String name, String title, Date stDate, Date edDate);
    
}