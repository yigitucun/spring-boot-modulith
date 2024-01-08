package com.ali.modulith.post.business.concretes;

import com.ali.modulith.category.business.rules.CategoryBusinessRules;
import com.ali.modulith.core.utils.modelMapper.ModelMapperService;
import com.ali.modulith.post.business.abstracts.PostService;
import com.ali.modulith.post.business.rules.PostBusinessRules;
import com.ali.modulith.post.dataAccess.abstracts.IPostRepository;
import com.ali.modulith.post.dto.requests.AddPostRequest;
import com.ali.modulith.post.dto.requests.UpdatePostRequest;
import com.ali.modulith.post.entities.Post;
import com.ali.modulith.post.projections.ListPostProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostManager implements PostService {
    private final ModelMapperService mapperService;
    private final IPostRepository postRepository;
    private final CategoryBusinessRules categoryBusinessRules;
    private final PostBusinessRules postBusinessRules;

    public PostManager(ModelMapperService mapperService, IPostRepository postRepository, CategoryBusinessRules categoryBusinessRules, PostBusinessRules postBusinessRules) {
        this.mapperService = mapperService;
        this.postRepository = postRepository;
        this.categoryBusinessRules = categoryBusinessRules;
        this.postBusinessRules = postBusinessRules;
    }

    @Override
    public UpdatePostRequest update(UpdatePostRequest request) {
        this.postBusinessRules.checkIfPostId(request.getId());
        this.categoryBusinessRules.checkIfCategoryId(request.getCategoryId());
        this.postRepository.save(this.mapperService.toEntity(Post.class,request));
        return request;
    }

    @Override
    public ListPostProjection getById(int id) {
        this.postBusinessRules.checkIfPostId(id);
        return this.postRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        this.postBusinessRules.checkIfPostId(id);
        this.postRepository.deleteById(id);
    }

    @Override
    public List<ListPostProjection> getAll() {
        return this.postRepository.getAllPosts();
    }

    @Override
    public AddPostRequest add(AddPostRequest request) {
        this.categoryBusinessRules.checkIfCategoryId(request.getCategoryId());
        this.postRepository.save(this.mapperService.toEntity(Post.class,request));
        return request;
    }
}
