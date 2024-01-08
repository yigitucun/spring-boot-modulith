package com.ali.modulith.post.business.rules;

import com.ali.modulith.core.exceptions.exception.BusinessException;
import com.ali.modulith.post.dataAccess.abstracts.IPostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PostBusinessRules {
    private final IPostRepository postRepository;

    public PostBusinessRules(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public void checkIfPostId(int id){
        if (!this.postRepository.existsById(id)){
            throw new BusinessException("Makale bulunamadı", HttpStatus.NOT_FOUND);
        }
    }
}
