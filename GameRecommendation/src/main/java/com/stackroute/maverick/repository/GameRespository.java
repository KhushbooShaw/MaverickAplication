package com.stackroute.maverick.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.RecommendationCategory;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.RecommendationUser;

import java.util.Date;
import java.util.List;




public interface GameRespository extends Neo4jRepository<RecommendationGame, Long>{
    
    //query for creating node of RecommendationGame with relationship with category
    
    @Query("match (m:RecommendationCategory) where m.category_id={category_id} create (n:RecommendationGame)-[r:recommendation_game_of]->(m) set r.timeStamp={time},n.game_id={id},n.name={name},n.gameImage={gameImage},n.category_id={category_id},n.game_type_id={game_type_id},n.game_type={game_type},n.timestamp={time},n.game_rules={game_rules},n.topic_id={topic_id},n.game_description={game_description},n.recommendation={recommendation} return n;")
    List<RecommendationGame> addGame(@Param("id") int id,@Param("name") String name,@Param("gameImage") String gameImage,@Param("category_id") int category_id,@Param("game_type_id") int game_type_id,@Param("game_type") String game_type,@Param("game_rules") String game_rules,@Param("recommendation") String recommendation,@Param("game_description") String game_description,@Param("topic_id") int topic_id,@Param("time") String timestamp);

    //query for checking whether a RecommendationGame node exists or not
    
    @Query("match (n:RecommendationGame) where n.game_id={id} return n;")
    List<RecommendationGame> checkGameId(@Param("id") int id);
    
    //query for updating an existing RecommendationGame node 
    
    @Query("match (n:RecommendationGame) where n.game_id={id} set r.timeStamp={time},n.game_id={id},n.name={name},n.gameImage={gameImage},n.category_id={category_id},n.game_type_id={game_type_id},n.game_type={game_type},n.timestamp={time},n.game_rules={game_rules},n.topic_id={topic_id},n.game_description={game_description},n.recommendation={recommendation} return n;")
    List<RecommendationGame> updateGame(@Param("id") int id,@Param("name") String name,@Param("gameImage") String gameImage,@Param("category_id") int category_id,@Param("game_type_id") int game_type_id,@Param("game_type") String game_type,@Param("game_rules") String game_rules,@Param("recommendation") String recommendation,@Param("game_description") String game_description,@Param("topic_id") int topic_id,@Param("time") String timestamp);
    
    //query for getting games in a particular category using relationship
    
    @Query("match (n:RecommendationGame)-[r:recommendation_game_of]->(m:RecommendationCategory) where m.category_id={id} return n;")
	List<RecommendationGame> gamesInCategory(@Param("id") int id);

    //query for getting most games played by user
    
    @Query("match (n:RecommendationUser)-[r:recommendation_game_playedBy_user]->(g:RecommendationGame) where n.userId={user_id} return g,count(r) order by count(r) desc;")
	List<RecommendationGame> gamemostPlayedByUser(@Param("user_id") int user_id);
	
}
