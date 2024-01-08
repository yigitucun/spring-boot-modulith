package com.ali.modulith.post.dataAccess.abstracts;

import com.ali.modulith.post.entities.Post;
import com.ali.modulith.post.projections.ListPostProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post,Integer> {
    boolean existsById(long id);
    @Query("SELECT p.id as id,p.title as title,p.content as content,c.category as category FROM Post p INNER JOIN Category c ON c.id=p.category.id")
    List<ListPostProjection> getAllPosts();
    @Query("SELECT p.id as id,p.title as title,p.content as content,c.category as category FROM Post p INNER JOIN Category c ON c.id=p.category.id")
    ListPostProjection findById(long id);

}
